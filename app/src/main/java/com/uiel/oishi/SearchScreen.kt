package com.uiel.oishi

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.room.Room
import com.uiel.oishi.dao.FoodDao
import com.uiel.oishi.design_system.OishiColor
import com.uiel.oishi.design_system.OishiTypography
import com.uiel.oishi.entity.Food
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    category: Category,
) {
    val data = Data.data
    val context = LocalContext.current

    val database: OishiDataBase by lazy {
        Room.databaseBuilder(
            context = context,
            OishiDataBase::class.java,
            "food-database"
        ).fallbackToDestructiveMigration().build()
    }

    val foodDao: FoodDao by lazy {
        database.getFoodDao()
    }

    val (shouldShowDialog, onChangeShouldShowDialog) = remember {
        mutableStateOf(false)
    }

    val (foodData, onChanFoodData) = remember {
        mutableStateOf(
            Food(
                image = 0,
                title = "",
                description = "",
                category = Category.RESTAURANT,
            )
        )
    }

    if (shouldShowDialog) {
        AlertDialog(
            title = { Text(text = "장바구니에 추가하시겠습니까?") },
            onDismissRequest = { onChangeShouldShowDialog(false) },
            confirmButton = {
                TextButton(
                    onClick = {
                        onChangeShouldShowDialog(false)
                        CoroutineScope(Dispatchers.IO).launch {
                            foodDao.saveFood(food = foodData)
                        }
                    }
                ) {
                    Text(text = "확인")
                }
            },
            dismissButton = {
                TextButton(onClick = { onChangeShouldShowDialog(false) }) {
                    Text(text = "취소")
                }
            }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val selectItem: List<FoodItem> = data.filter { it.category == category }
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize(),
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(26.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            contentPadding = PaddingValues(horizontal = 20.dp),
        ) {
            items(selectItem) { foodItem ->
                Column(
                    modifier = Modifier
                        .padding(bottom = 40.dp)
                        .clickable {
                            onChangeShouldShowDialog(true)
                            onChanFoodData(
                                Food(
                                    image = foodItem.image,
                                    title = foodItem.title,
                                    description = foodItem.description,
                                    category = foodItem.category,
                                )
                            )
                        },
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp)),
                        painter = painterResource(id = foodItem.image),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )
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
