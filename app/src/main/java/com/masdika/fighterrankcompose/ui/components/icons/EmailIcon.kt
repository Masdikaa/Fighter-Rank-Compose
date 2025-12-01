package com.masdika.fighterrankcompose.ui.components.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

@Suppress("ObjectPropertyName")
private var _EmailIcon: ImageVector? = null

val EmailIcon: ImageVector
    get() {
        if (_EmailIcon != null) {
            return _EmailIcon!!
        }
        _EmailIcon = ImageVector.Builder(
            name = "EmailIcon",
            defaultWidth = 512.dp,
            defaultHeight = 512.dp,
            viewportWidth = 512f,
            viewportHeight = 512f
        ).apply {
            path(fill = SolidColor(Color.Black)) {
                moveTo(407f, 0f)
                lineTo(105f, 0f)
                curveTo(47.1f, 0f, 0f, 47.1f, 0f, 105f)
                verticalLineToRelative(302f)
                curveToRelative(0f, 57.9f, 47.1f, 105f, 105f, 105f)
                horizontalLineToRelative(302f)
                curveToRelative(57.9f, 0f, 105f, -47.1f, 105f, -105f)
                lineTo(512f, 105f)
                curveTo(512f, 47.1f, 464.9f, 0f, 407f, 0f)
                close()
                moveTo(374.7f, 146f)
                lineTo(255.96f, 264.74f)
                lineTo(137.21f, 146f)
                horizontalLineToRelative(237.49f)
                close()
                moveTo(102.75f, 338.03f)
                arcTo(14.93f, 14.93f, 0f, isMoreThanHalf = false, isPositiveArc = true, 101f, 331f)
                lineTo(101f, 161f)
                curveToRelative(0f, -2.54f, 0.64f, -4.93f, 1.75f, -7.03f)
                lineTo(194.79f, 246f)
                lineToRelative(-92.03f, 92.03f)
                close()
                moveTo(137.21f, 346f)
                lineTo(216f, 267.21f)
                lineToRelative(39.96f, 39.96f)
                lineToRelative(40f, -40f)
                lineTo(374.79f, 346f)
                lineTo(137.21f, 346f)
                close()
                moveTo(411f, 331f)
                curveToRelative(0f, 2.54f, -0.64f, 4.93f, -1.75f, 7.03f)
                lineToRelative(-92.07f, -92.07f)
                lineToRelative(92.05f, -92.05f)
                arcTo(14.91f, 14.91f, 0f, isMoreThanHalf = false, isPositiveArc = true, 411f, 161f)
                verticalLineToRelative(170f)
                close()
            }
        }.build()

        return _EmailIcon!!
    }
