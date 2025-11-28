package com.masdika.fighterrankcompose.ui.components.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

@Suppress("ObjectPropertyName")
private var _GridIcon: ImageVector? = null

val GridIcon: ImageVector
    get() {
        if (_GridIcon != null) {
            return _GridIcon!!
        }
        _GridIcon = ImageVector.Builder(
            name = "GridIcon",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 512f,
            viewportHeight = 512f
        ).apply {
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 40f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(216f, 143.98f)
                curveTo(216f, 163.87f, 199.87f, 180f, 179.98f, 180f)
                horizontalLineTo(56.02f)
                curveTo(36.13f, 180f, 20f, 163.87f, 20f, 143.98f)
                verticalLineTo(56.02f)
                curveTo(20f, 36.13f, 36.13f, 20f, 56.02f, 20f)
                horizontalLineToRelative(123.96f)
                curveTo(199.87f, 20f, 216f, 36.13f, 216f, 56.02f)
                verticalLineToRelative(87.96f)
                close()
                moveTo(492f, 255.98f)
                curveTo(492f, 275.87f, 475.87f, 292f, 455.98f, 292f)
                horizontalLineTo(328.02f)
                curveTo(308.13f, 292f, 292f, 275.87f, 292f, 255.98f)
                verticalLineTo(56.02f)
                curveTo(292f, 36.13f, 308.13f, 20f, 328.02f, 20f)
                horizontalLineToRelative(127.96f)
                curveTo(475.87f, 20f, 492f, 36.13f, 492f, 56.02f)
                verticalLineToRelative(199.96f)
                close()
                moveTo(492f, 455.98f)
                curveTo(492f, 475.87f, 475.87f, 492f, 455.98f, 492f)
                horizontalLineTo(328.02f)
                curveTo(308.13f, 492f, 292f, 475.87f, 292f, 455.98f)
                verticalLineToRelative(-47.96f)
                curveTo(292f, 388.13f, 308.13f, 372f, 328.02f, 372f)
                horizontalLineToRelative(127.96f)
                curveTo(475.87f, 372f, 492f, 388.13f, 492f, 408.02f)
                verticalLineToRelative(47.96f)
                close()
                moveTo(216f, 455.98f)
                curveTo(216f, 475.87f, 199.87f, 492f, 179.98f, 492f)
                horizontalLineTo(56.02f)
                curveTo(36.13f, 492f, 20f, 475.87f, 20f, 455.98f)
                verticalLineTo(292.02f)
                curveTo(20f, 272.13f, 36.13f, 256f, 56.02f, 256f)
                horizontalLineToRelative(123.96f)
                curveTo(199.87f, 256f, 216f, 272.13f, 216f, 292.02f)
                verticalLineToRelative(163.96f)
                close()
            }
        }.build()

        return _GridIcon!!
    }