package com.masdika.fighterrankcompose.ui.screens.about.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.kyant.backdrop.backdrops.LayerBackdrop
import com.kyant.backdrop.backdrops.rememberLayerBackdrop
import com.kyant.backdrop.drawBackdrop
import com.kyant.backdrop.effects.blur
import com.kyant.backdrop.effects.lens
import com.kyant.backdrop.effects.vibrancy
import com.masdika.fighterrankcompose.R
import com.masdika.fighterrankcompose.ui.theme.FighterRankComposeTheme

@Composable
fun ProfileImage(
    model: String,
    backdrop: LayerBackdrop,
    modifier: Modifier = Modifier
) {
    val surfaceColor = MaterialTheme.colorScheme.background.copy(0.2f)

    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = modifier
            .drawBackdrop(
                backdrop = backdrop,
                shape = { CircleShape },
                effects = {
                    vibrancy()
                    blur(4f.dp.toPx())
                    lens(16f.dp.toPx(), 32f.dp.toPx())
                },
                onDrawSurface = { drawRect(surfaceColor) }
            )
    ) {
        AsyncImage(
            model = model,
            contentDescription = null,
            placeholder = painterResource(R.drawable.ic_launcher_foreground),
            error = painterResource(R.drawable.ic_launcher_foreground),
            contentScale = ContentScale.Fit,
            alignment = Alignment.Center,
            modifier = Modifier
                .size(160.dp)
                .padding(10.dp)
                .clip(CircleShape)
        )

    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun ProfileImagePreview() {
    FighterRankComposeTheme {
        val backdrop = rememberLayerBackdrop()
        ProfileImage(
            model = "",
            backdrop = backdrop
        )
    }
}