package com.masdika.fighterrankcompose.ui.components.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

@Suppress("ObjectPropertyName")
private var _LinkedinIcon: ImageVector? = null

val LinkedinIcon: ImageVector
    get() {
        if (_LinkedinIcon != null) {
            return _LinkedinIcon!!
        }
        _LinkedinIcon = ImageVector.Builder(
            name = "LinkedinIcon",
            defaultWidth = 100.dp,
            defaultHeight = 100.dp,
            viewportWidth = 176f,
            viewportHeight = 176f
        ).apply {
            path(fill = SolidColor(Color.Black)) {
                moveTo(152f, 0f)
                lineTo(24f, 0f)
                arcTo(24f, 24f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0f, 24f)
                verticalLineToRelative(128f)
                arcToRelative(24f, 24f, 0f, isMoreThanHalf = false, isPositiveArc = false, 24f, 24f)
                horizontalLineToRelative(128f)
                arcToRelative(
                    24f,
                    24f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = false,
                    24f,
                    -24f
                )
                lineTo(176f, 24f)
                arcToRelative(
                    24f,
                    24f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = false,
                    -24f,
                    -24f
                )
                close()
                moveTo(60f, 139.28f)
                arcToRelative(
                    3.71f,
                    3.71f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = true,
                    -3.71f,
                    3.72f
                )
                lineTo(40.48f, 143f)
                arcToRelative(
                    3.71f,
                    3.71f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = true,
                    -3.72f,
                    -3.72f
                )
                lineTo(36.76f, 73f)
                arcToRelative(
                    3.72f,
                    3.72f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = true,
                    3.72f,
                    -3.72f
                )
                horizontalLineToRelative(15.81f)
                arcTo(3.72f, 3.72f, 0f, isMoreThanHalf = false, isPositiveArc = true, 60f, 73f)
                close()
                moveTo(48.38f, 63f)
                arcToRelative(15f, 15f, 0f, isMoreThanHalf = true, isPositiveArc = true, 15f, -15f)
                arcToRelative(15f, 15f, 0f, isMoreThanHalf = false, isPositiveArc = true, -15f, 15f)
                close()
                moveTo(142.64f, 139.54f)
                arcToRelative(
                    3.41f,
                    3.41f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = true,
                    -3.42f,
                    3.42f
                )
                horizontalLineToRelative(-17f)
                arcToRelative(
                    3.41f,
                    3.41f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = true,
                    -3.42f,
                    -3.42f
                )
                verticalLineToRelative(-31.05f)
                curveToRelative(0f, -4.64f, 1.36f, -20.32f, -12.13f, -20.32f)
                curveToRelative(-10.45f, 0f, -12.58f, 10.73f, -13f, 15.55f)
                verticalLineToRelative(35.86f)
                arcTo(3.42f, 3.42f, 0f, isMoreThanHalf = false, isPositiveArc = true, 90.3f, 143f)
                lineTo(73.88f, 143f)
                arcToRelative(
                    3.41f,
                    3.41f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = true,
                    -3.41f,
                    -3.42f
                )
                lineTo(70.47f, 72.71f)
                arcToRelative(
                    3.41f,
                    3.41f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = true,
                    3.41f,
                    -3.42f
                )
                lineTo(90.3f, 69.29f)
                arcToRelative(
                    3.42f,
                    3.42f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = true,
                    3.42f,
                    3.42f
                )
                verticalLineToRelative(5.78f)
                curveToRelative(3.88f, -5.83f, 9.63f, -10.31f, 21.9f, -10.31f)
                curveToRelative(27.18f, 0f, 27f, 25.38f, 27f, 39.32f)
                close()
            }
        }.build()

        return _LinkedinIcon!!
    }
