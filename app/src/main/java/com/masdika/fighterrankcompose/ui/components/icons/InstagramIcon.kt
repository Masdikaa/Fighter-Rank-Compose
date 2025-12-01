package com.masdika.fighterrankcompose.ui.components.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

@Suppress("ObjectPropertyName")
private var _InstagramIcon: ImageVector? = null

val InstagramIcon: ImageVector
    get() {
        if (_InstagramIcon != null) {
            return _InstagramIcon!!
        }
        _InstagramIcon = ImageVector.Builder(
            name = "InstagramIcon",
            defaultWidth = 100.dp,
            defaultHeight = 100.dp,
            viewportWidth = 512f,
            viewportHeight = 512f
        ).apply {
            path(fill = SolidColor(Color.Black)) {
                moveTo(301f, 256f)
                curveToRelative(0f, 24.85f, -20.15f, 45f, -45f, 45f)
                reflectiveCurveToRelative(-45f, -20.15f, -45f, -45f)
                reflectiveCurveToRelative(20.15f, -45f, 45f, -45f)
                reflectiveCurveToRelative(45f, 20.15f, 45f, 45f)
                close()
                moveTo(301f, 256f)
            }
            path(fill = SolidColor(Color.Black)) {
                moveTo(332f, 120f)
                lineTo(180f, 120f)
                curveToRelative(-33.09f, 0f, -60f, 26.91f, -60f, 60f)
                verticalLineToRelative(152f)
                curveToRelative(0f, 33.09f, 26.91f, 60f, 60f, 60f)
                horizontalLineToRelative(152f)
                curveToRelative(33.09f, 0f, 60f, -26.91f, 60f, -60f)
                lineTo(392f, 180f)
                curveToRelative(0f, -33.09f, -26.91f, -60f, -60f, -60f)
                close()
                moveTo(256f, 331f)
                curveToRelative(-41.35f, 0f, -75f, -33.65f, -75f, -75f)
                reflectiveCurveToRelative(33.65f, -75f, 75f, -75f)
                reflectiveCurveToRelative(75f, 33.65f, 75f, 75f)
                reflectiveCurveToRelative(-33.65f, 75f, -75f, 75f)
                close()
                moveTo(342f, 185f)
                curveToRelative(-8.28f, 0f, -15f, -6.72f, -15f, -15f)
                reflectiveCurveToRelative(6.72f, -15f, 15f, -15f)
                reflectiveCurveToRelative(15f, 6.72f, 15f, 15f)
                reflectiveCurveToRelative(-6.72f, 15f, -15f, 15f)
                close()
                moveTo(342f, 185f)
            }
            path(fill = SolidColor(Color.Black)) {
                moveTo(377f, 0f)
                lineTo(135f, 0f)
                curveTo(60.56f, 0f, 0f, 60.56f, 0f, 135f)
                verticalLineToRelative(242f)
                curveToRelative(0f, 74.44f, 60.56f, 135f, 135f, 135f)
                horizontalLineToRelative(242f)
                curveToRelative(74.44f, 0f, 135f, -60.56f, 135f, -135f)
                lineTo(512f, 135f)
                curveTo(512f, 60.56f, 451.44f, 0f, 377f, 0f)
                close()
                moveTo(422f, 332f)
                curveToRelative(0f, 49.63f, -40.38f, 90f, -90f, 90f)
                lineTo(180f, 422f)
                curveToRelative(-49.63f, 0f, -90f, -40.38f, -90f, -90f)
                lineTo(90f, 180f)
                curveToRelative(0f, -49.63f, 40.38f, -90f, 90f, -90f)
                horizontalLineToRelative(152f)
                curveToRelative(49.63f, 0f, 90f, 40.38f, 90f, 90f)
                close()
                moveTo(422f, 332f)
            }
        }.build()

        return _InstagramIcon!!
    }