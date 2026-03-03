package ks.heydrink.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
//val Typography = Typography(
//    bodyLarge = TextStyle(
//        fontFamily = FontFamily.Default,
//        fontWeight = FontWeight.Normal,
//        fontSize = 16.sp,
//        lineHeight = 24.sp,
//        letterSpacing = 0.5.sp
//    )
//    /* Other default text styles to override
//    titleLarge = TextStyle(
//        fontFamily = FontFamily.Default,
//        fontWeight = FontWeight.Normal,
//        fontSize = 22.sp,
//        lineHeight = 28.sp,
//        letterSpacing = 0.sp
//    ),
//    labelSmall = TextStyle(
//        fontFamily = FontFamily.Default,
//        fontWeight = FontWeight.Medium,
//        fontSize = 11.sp,
//        lineHeight = 16.sp,
//        letterSpacing = 0.5.sp
//    )
//    */
//)

val AppTypography = Typography().run {
    copy(
        displayLarge = displayLarge.copy(color = Color.Black, fontFamily = MontserratAlternates),
        displayMedium = displayMedium.copy(color = Color.Black, fontFamily = MontserratAlternates),
        displaySmall = displaySmall.copy(color = Color.Black, fontFamily = MontserratAlternates),

        headlineLarge = headlineLarge.copy(color = Color.Black, fontFamily = MontserratAlternates),
        headlineMedium = headlineMedium.copy(color = Color.Black, fontFamily = MontserratAlternates),
        headlineSmall = headlineSmall.copy(color = Color.Black, fontFamily = MontserratAlternates),

        titleLarge = titleLarge.copy(color = Color.Black, fontFamily = MontserratAlternates),
        titleMedium = titleMedium.copy(color = Color.Black, fontFamily = MontserratAlternates),
        titleSmall = titleSmall.copy(color = Color.Black, fontFamily = MontserratAlternates),

        bodyLarge = bodyLarge.copy(color = Color.Black, fontFamily = MontserratAlternates),
        bodyMedium = bodyMedium.copy(color = Color.Black, fontFamily = MontserratAlternates),
        bodySmall = bodySmall.copy(color = Color.Black, fontFamily = MontserratAlternates),

        labelLarge = labelLarge.copy(color = Color.Black, fontFamily = MontserratAlternates),
        labelMedium = labelMedium.copy(color = Color.Black, fontFamily = MontserratAlternates),
        labelSmall = labelSmall.copy(color = Color.Black, fontFamily = MontserratAlternates),
    )
}