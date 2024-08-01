package com.uiel.oishi.design_system

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.uiel.oishi.R

private val PretendardFamily = FontFamily(
    listOf(
        Font(
            resId = R.font.pretendard_bold,
            weight = FontWeight.Bold,
        ),
        Font(
            resId = R.font.pretendard_medium,
            weight = FontWeight.Medium,
        ),
    ),
)

private val platFormTextStyle = PlatformTextStyle(
    includeFontPadding = false,
)

/**
 * JobisTypography defines fontFamily, fontSize, fontWeight, lineHeight and platformStyle in TextStyle.
 */
object OishiTypography {
    val LargeText
        @Composable get() = TextStyle(
            fontFamily = PretendardFamily,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 36.sp,
            platformStyle = platFormTextStyle,
            color = OishiColor.text1,
        )

    val Title1
        @Composable get() = TextStyle(
            fontFamily = PretendardFamily,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 29.sp,
            platformStyle = platFormTextStyle,
            color = OishiColor.text1,
        )

    val Title2
        @Composable get() = TextStyle(
            fontFamily = PretendardFamily,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 24.sp,
            platformStyle = platFormTextStyle,
            color = OishiColor.text1,
        )

    val Subtext1
        @Composable get() = TextStyle(
            fontFamily = PretendardFamily,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 19.sp,
            platformStyle = platFormTextStyle,
            color = OishiColor.text1,
        )

    val Subtext2
        @Composable get() = TextStyle(
            fontFamily = PretendardFamily,
            fontSize = 13.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 16.sp,
            platformStyle = platFormTextStyle,
            color = OishiColor.text1,
        )

    val Caption
        @Composable get() = TextStyle(
            fontFamily = PretendardFamily,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 14.sp,
            platformStyle = platFormTextStyle,
            color = OishiColor.text1,
        )

    val NavigationText
        @Composable get() = TextStyle(
            fontFamily = PretendardFamily,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 14.sp,
            platformStyle = platFormTextStyle,
            color = OishiColor.text1,
        )
}
