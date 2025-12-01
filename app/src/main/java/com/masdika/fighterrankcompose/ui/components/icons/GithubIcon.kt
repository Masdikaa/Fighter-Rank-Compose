package com.masdika.fighterrankcompose.ui.components.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

@Suppress("ObjectPropertyName")
private var _GithubIcon: ImageVector? = null

val GithubIcon: ImageVector
    get() {
        if (_GithubIcon != null) {
            return _GithubIcon!!
        }
        _GithubIcon = ImageVector.Builder(
            name = "GithubIcon",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
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
                moveTo(105.25f, 140.55f)
                curveToRelative(-2.82f, 0.54f, -3.78f, -1.16f, -3.78f, -2.57f)
                curveToRelative(0f, -1.76f, 0.07f, -7.57f, 0.07f, -14.8f)
                curveToRelative(0f, -5.07f, -1.79f, -8.38f, -3.71f, -10f)
                curveToRelative(12.23f, -1.33f, 25.09f, -5.9f, 25.09f, -26.66f)
                arcTo(
                    20.71f,
                    20.71f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = false,
                    117.28f,
                    72f
                )
                curveToRelative(0.55f, -1.37f, 2.41f, -6.87f, -0.55f, -14.31f)
                curveToRelative(0f, 0f, -4.6f, -1.45f, -15f, 5.54f)
                arcToRelative(
                    52.85f,
                    52.85f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = false,
                    -27.5f,
                    0f
                )
                curveToRelative(-10.52f, -7f, -15.13f, -5.54f, -15.13f, -5.54f)
                curveToRelative(-3f, 7.46f, -1.1f, 12.96f, -0.53f, 14.31f)
                arcToRelative(
                    20.64f,
                    20.64f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = false,
                    -5.66f,
                    14.5f
                )
                curveToRelative(0f, 20.7f, 12.84f, 25.35f, 25f, 26.7f)
                arcToRelative(
                    11.45f,
                    11.45f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = false,
                    -3.48f,
                    7.23f
                )
                curveToRelative(-3.15f, 1.38f, -11.12f, 3.77f, -16f, -4.49f)
                curveToRelative(0f, 0f, -2.9f, -5.2f, -8.42f, -5.57f)
                curveToRelative(0f, 0f, -5.37f, -0.07f, -0.39f, 3.28f)
                curveToRelative(0f, 0f, 3.62f, 1.67f, 6.12f, 7.9f)
                curveToRelative(0f, 0f, 3.23f, 10.51f, 18.53f, 7.26f)
                curveToRelative(0f, 4.5f, 0.06f, 7.9f, 0.06f, 9.19f)
                reflectiveCurveToRelative(-1f, 3.1f, -3.75f, 2.59f)
                curveTo(48.76f, 133.47f, 33f, 113.22f, 33f, 89.34f)
                curveToRelative(0f, -29.85f, 24.61f, -54f, 55f, -54f)
                reflectiveCurveToRelative(55f, 24.2f, 55f, 54.05f)
                curveToRelative(0f, 23.79f, -15.74f, 44.06f, -37.75f, 51.16f)
                close()
            }
        }.build()

        return _GithubIcon!!
    }