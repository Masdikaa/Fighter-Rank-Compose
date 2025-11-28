package com.masdika.fighterrankcompose.ui.components.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

@Suppress("ObjectPropertyName")
private var _ListIcon: ImageVector? = null

val ListIcon: ImageVector
    get() {
        if (_ListIcon != null) {
            return _ListIcon!!
        }
        _ListIcon = ImageVector.Builder(
            name = "ListIcon",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 512f,
            viewportHeight = 512f
        ).apply {
            path(fill = SolidColor(Color.Black)) {
                moveTo(141.26f, 52f)
                horizontalLineTo(34.74f)
                curveTo(15.59f, 52f, 0f, 67.59f, 0f, 86.75f)
                verticalLineToRelative(106.51f)
                curveTo(0f, 212.41f, 15.59f, 228f, 34.74f, 228f)
                horizontalLineToRelative(106.51f)
                curveTo(160.41f, 228f, 176f, 212.41f, 176f, 193.26f)
                verticalLineTo(86.75f)
                curveTo(176f, 67.59f, 160.41f, 52f, 141.26f, 52f)
                close()
                moveTo(141.26f, 284f)
                horizontalLineTo(34.74f)
                curveTo(15.59f, 284f, 0f, 299.59f, 0f, 318.74f)
                verticalLineToRelative(106.51f)
                curveTo(0f, 444.41f, 15.59f, 460f, 34.74f, 460f)
                horizontalLineToRelative(106.51f)
                curveTo(160.41f, 460f, 176f, 444.41f, 176f, 425.26f)
                verticalLineToRelative(-106.51f)
                curveTo(176f, 299.59f, 160.41f, 284f, 141.26f, 284f)
                close()
                moveTo(496f, 132f)
                horizontalLineTo(240f)
                curveToRelative(-8.84f, 0f, -16f, -7.16f, -16f, -16f)
                reflectiveCurveToRelative(7.16f, -16f, 16f, -16f)
                horizontalLineToRelative(256f)
                curveToRelative(8.84f, 0f, 16f, 7.16f, 16f, 16f)
                reflectiveCurveToRelative(-7.16f, 16f, -16f, 16f)
                close()
                moveTo(408f, 192f)
                horizontalLineTo(240f)
                curveToRelative(-8.84f, 0f, -16f, -7.16f, -16f, -16f)
                reflectiveCurveToRelative(7.16f, -16f, 16f, -16f)
                horizontalLineToRelative(168f)
                curveToRelative(8.84f, 0f, 16f, 7.16f, 16f, 16f)
                reflectiveCurveToRelative(-7.16f, 16f, -16f, 16f)
                close()
                moveTo(496f, 360f)
                horizontalLineTo(240f)
                curveToRelative(-8.84f, 0f, -16f, -7.16f, -16f, -16f)
                reflectiveCurveToRelative(7.16f, -16f, 16f, -16f)
                horizontalLineToRelative(256f)
                curveToRelative(8.84f, 0f, 16f, 7.16f, 16f, 16f)
                reflectiveCurveToRelative(-7.16f, 16f, -16f, 16f)
                close()
                moveTo(408f, 424f)
                horizontalLineTo(240f)
                curveToRelative(-8.84f, 0f, -16f, -7.16f, -16f, -16f)
                reflectiveCurveToRelative(7.16f, -16f, 16f, -16f)
                horizontalLineToRelative(168f)
                curveToRelative(8.84f, 0f, 16f, 7.16f, 16f, 16f)
                reflectiveCurveToRelative(-7.16f, 16f, -16f, 16f)
                close()
            }
        }.build()

        return _ListIcon!!
    }