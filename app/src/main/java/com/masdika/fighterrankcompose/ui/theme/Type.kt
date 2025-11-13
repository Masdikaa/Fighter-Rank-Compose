package com.masdika.fighterrankcompose.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.masdika.fighterrankcompose.R

val Sternbach = FontFamily(Font(resId = R.font.sternbach, weight = FontWeight.Normal))
val MavenPro = FontFamily(Font(resId = R.font.maven_pro, weight = FontWeight.Normal))

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)