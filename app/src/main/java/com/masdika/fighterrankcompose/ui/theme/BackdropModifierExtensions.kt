package com.masdika.fighterrankcompose.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.unit.dp
import com.kyant.backdrop.Backdrop
import com.kyant.backdrop.drawBackdrop
import com.kyant.backdrop.effects.blur
import com.kyant.backdrop.effects.lens
import com.kyant.backdrop.effects.vibrancy

fun Modifier.glassmorphism(
    backdrop: Backdrop,
    surfaceColor: Color,
    blurRadius: Float = 6f,
    shape: RoundedCornerShape = RoundedCornerShape(10.dp),
    depthEffect: Boolean = true,
    chromaticAberration: Boolean = true
) = this.drawBackdrop(
    backdrop = backdrop,
    shape = { shape },
    effects = {
        vibrancy()
        blur(
            radius = blurRadius.dp.toPx(),
            edgeTreatment = TileMode.Clamp
        )
        lens(
            refractionHeight = 16f.dp.toPx(),
            refractionAmount = 32f.dp.toPx(),
            depthEffect = depthEffect,
            chromaticAberration = chromaticAberration
        )
    },
    onDrawSurface = { drawRect(surfaceColor) }
)