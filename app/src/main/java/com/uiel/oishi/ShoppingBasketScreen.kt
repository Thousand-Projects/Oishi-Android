package com.uiel.oishi

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.room.Room
import com.uiel.oishi.design_system.OishiColor
import com.uiel.oishi.design_system.OishiTypography
import com.uiel.oishi.entity.Food
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun ShoppingBasketScreen(
    modifier: Modifier = Modifier,
    category: Category,
) {
    val context = LocalContext.current
    val room = Room.databaseBuilder(context, OishiDataBase::class.java, "food-database")
        .fallbackToDestructiveMigration().build()
    val dao = room.getFoodDao()
    val data = remember { mutableStateListOf<Food>() }

    LaunchedEffect(Unit) {
        launch(Dispatchers.IO) {
            runCatching {
                dao.queryFood()
            }.onSuccess { foodData ->
                data.addAll(foodData)
            }.onFailure {
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "장바구니를 불러오지 못했어요.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val selectItem: List<Food> = data.filter { it.category == category }

        if(selectItem.isEmpty()) {
            Text(
                text = "장바구니가 비어있어요",
                style = OishiTypography.Subtext1,
                color = OishiColor.sub1,
            )
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(26.dp),
            verticalArrangement = Arrangement.spacedBy(40.dp),
            contentPadding = PaddingValues(horizontal = 20.dp),
        ) {
            items(selectItem) { foodItem ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Box(
                        contentAlignment = Alignment.TopEnd,
                    ) {
                        Image(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp)),
                            painter = painterResource(id = foodItem.image),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                        )
                        IconButton(
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(Color.Black.copy(0.7f)),
                            onClick = {
                                CoroutineScope(Dispatchers.IO).launch {
                                    dao.deleteFood(foodItem.id)
                                }
                                data.remove(foodItem)
                                Toast.makeText(context,"삭제되었습니다.",Toast.LENGTH_SHORT).show()
                            }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.round_close_24),
                                contentDescription = null,
                                tint = Color.White,
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = foodItem.title,
                        style = OishiTypography.Subtext1,
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = foodItem.description,
                        style = OishiTypography.Caption,
                        color = OishiColor.sub2,
                    )
                }
            }
        }
    }
}