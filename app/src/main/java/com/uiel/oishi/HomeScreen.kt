package com.uiel.oishi

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.uiel.oishi.design_system.Filter
import com.uiel.oishi.design_system.OishiColor
import com.uiel.oishi.design_system.OishiTypography
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState { 2 }
    val coroutineScope = rememberCoroutineScope()
    var category by remember { mutableStateOf(Category.RESTAURANT) }
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 40.dp,
                    start = 22.dp
                )
        ) {
            Text(
                modifier = Modifier
                    .clickable(
                        onClick = {
                            coroutineScope.launch {
                                pagerState.scrollToPage(0)
                            }
                        },
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                    ),


                text = "검색",
                style = OishiTypography.LargeText,
                color = if (pagerState.currentPage == 0) OishiColor.text1 else OishiColor.sub3,
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                modifier = Modifier
                    .clickable(
                        onClick = {
                            coroutineScope.launch {
                                pagerState.scrollToPage(1)
                            }
                        },
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                    ),
                text = "장바구니",
                style = OishiTypography.LargeText,
                color = if (pagerState.currentPage == 1) OishiColor.text1 else OishiColor.sub3,
            )
        }
        val restaurant = Location(
            image = R.drawable.ic_restaurant,
            title = "식당",
            category = Category.RESTAURANT,
        )
        val convenienceStore = Location(
            image = R.drawable.ic_convenience_store,
            title = "편의점",
            category = Category.CONVENIENCESTORE,
        )
        val donquijote = Location(
            image = R.drawable.ic_convenience_store,
            title = "돈키호테 & 드럭스토어",
            category = Category.DONQUIJOTE,
        )
        Spacer(modifier = Modifier.height(30.dp))
        Filter(
            filterList = listOf(restaurant, convenienceStore, donquijote)
        ) { filterCategory ->
            category = filterCategory
        }
        Spacer(modifier = Modifier.height(28.dp))
        HorizontalPager(
            modifier = Modifier.fillMaxWidth(),
            state = pagerState
        ) { index ->
            when (index) {
                0 -> SearchScreen(
                    category = category
                )

                else -> ShoppingBasketScreen(
                    category = category
                )
            }
        }
    }
}

class Location(
    val image: Int,
    val title: String,
    val category: Category,
)
