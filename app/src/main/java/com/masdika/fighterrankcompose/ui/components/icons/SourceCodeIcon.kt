package com.masdika.fighterrankcompose.ui.components.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

@Suppress("ObjectPropertyName")
private var _SourceCodeIcon: ImageVector? = null

val SourceCodeIcon: ImageVector
    get() {
        if (_SourceCodeIcon != null) {
            return _SourceCodeIcon!!
        }
        _SourceCodeIcon = ImageVector.Builder(
            name = "SourceCodeIcon",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(1.293f, 12.707f)
                lineToRelative(4f, 4f)
                arcToRelative(
                    1f,
                    1f,
                    0f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    1.414f,
                    -1.414f
                )
                lineTo(3.414f, 12f)
                lineToRelative(3.293f, -3.293f)
                arcToRelative(
                    1f,
                    1f,
                    0f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    -1.414f,
                    -1.414f
                )
                lineToRelative(-4f, 4f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0f, 1.414f)
                close()
                moveTo(18.707f, 7.293f)
                arcToRelative(
                    1f,
                    1f,
                    0f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    -1.414f,
                    1.414f
                )
                lineTo(20.586f, 12f)
                lineToRelative(-3.293f, 3.293f)
                arcToRelative(
                    1f,
                    1f,
                    0f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    1.414f,
                    1.414f
                )
                lineToRelative(4f, -4f)
                arcToRelative(
                    1f,
                    1f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = false,
                    0f,
                    -1.414f
                )
                close()
                moveTo(13.039f, 4.726f)
                lineToRelative(-4f, 14f)
                arcToRelative(
                    1f,
                    1f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = false,
                    0.686f,
                    1.236f
                )
                arcTo(1.053f, 1.053f, 0f, isMoreThanHalf = false, isPositiveArc = false, 10f, 20f)
                arcToRelative(
                    1f,
                    1f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = false,
                    0.961f,
                    -0.726f
                )
                lineToRelative(4f, -14f)
                arcToRelative(
                    1f,
                    1f,
                    0f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    -1.922f,
                    -0.548f
                )
                close()
            }
        }.build()

        return _SourceCodeIcon!!
    }