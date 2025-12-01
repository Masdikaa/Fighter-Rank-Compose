package com.masdika.fighterrankcompose.ui.screens.about

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kyant.backdrop.backdrops.rememberLayerBackdrop
import com.kyant.backdrop.drawBackdrop
import com.kyant.backdrop.effects.blur
import com.kyant.backdrop.effects.lens
import com.kyant.backdrop.effects.vibrancy
import com.masdika.fighterrankcompose.ui.components.icons.EmailIcon
import com.masdika.fighterrankcompose.ui.components.icons.GithubIcon
import com.masdika.fighterrankcompose.ui.components.icons.InstagramIcon
import com.masdika.fighterrankcompose.ui.components.icons.LinkedinIcon
import com.masdika.fighterrankcompose.ui.screens.about.components.ContentAbout
import com.masdika.fighterrankcompose.ui.screens.about.components.ContentCard
import com.masdika.fighterrankcompose.ui.screens.about.components.ProfileImage
import com.masdika.fighterrankcompose.ui.theme.BebasNeue
import com.masdika.fighterrankcompose.ui.theme.FighterRankComposeTheme
import com.masdika.fighterrankcompose.ui.theme.MainRed

@Composable
fun AboutScreen(
    modifier: Modifier = Modifier
) {
    val backdrop = rememberLayerBackdrop()
    val surfaceColor = MaterialTheme.colorScheme.background.copy(0.2f)
    
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colorStops = arrayOf(
                        0.0f to MainRed,
                        0.2f to MainRed.copy(0.8f),
                        0.4f to MainRed.copy(0.6f),
                        0.6f to MainRed.copy(0.4f),
                        0.8f to MainRed.copy(0.2f),
                        1f to MaterialTheme.colorScheme.background
                    )
                )
            )
    ) {
        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.25f)
        ) {
            ProfileImage(
                model = "",
                modifier = Modifier.drawBackdrop(
                    backdrop = backdrop,
                    shape = { CircleShape },
                    effects = {
                        vibrancy()
                        lens(
                            refractionHeight = 16f.dp.toPx(),
                            refractionAmount = 32f.dp.toPx()
                        )
                        blur(radius = 4f.dp.toPx())
                    },
                    onDrawSurface = { drawRect(surfaceColor) }
                )
            )
        }
        Spacer(Modifier.fillMaxHeight(0.03f))
        Text(
            text = "Masdika Ilhan Mansiz".uppercase(),
            textAlign = TextAlign.Center,
            fontFamily = BebasNeue,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.fillMaxHeight(0.03f))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .drawBackdrop(
                    backdrop = backdrop,
                    shape = { RoundedCornerShape(10.dp) },
                    effects = {
                        vibrancy()
                        blur(
                            radius = 4f.dp.toPx(),
                            edgeTreatment = TileMode.Clamp
                        )
                        lens(
                            refractionHeight = 16f.dp.toPx(),
                            refractionAmount = 32f.dp.toPx(),
                            depthEffect = true,
                            chromaticAberration = true
                        )
                    },
                    onDrawSurface = { drawRect(surfaceColor) }
                )
        ) {
            val contentCardModifier: Modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 10.dp)
                .padding(top = 10.dp)
                .clip(RoundedCornerShape(10.dp))
                .drawBackdrop(
                    backdrop = backdrop,
                    shape = { RoundedCornerShape(10.dp) },
                    effects = {
                        vibrancy()
                        blur(
                            radius = 6f.dp.toPx(),
                            edgeTreatment = TileMode.Clamp
                        )
                        lens(
                            refractionHeight = 16f.dp.toPx(),
                            refractionAmount = 32f.dp.toPx(),
                            depthEffect = true,
                            chromaticAberration = true
                        )
                    },
                    onDrawSurface = { drawRect(surfaceColor.copy(0.3f)) }
                )
            ContentAbout(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                    .padding(top = 10.dp)
                    .drawBackdrop(
                        backdrop = backdrop,
                        shape = { RoundedCornerShape(10.dp) },
                        effects = {
                            vibrancy()
                            blur(
                                radius = 6f.dp.toPx(),
                                edgeTreatment = TileMode.Clamp
                            )
                            lens(
                                refractionHeight = 16f.dp.toPx(),
                                refractionAmount = 32f.dp.toPx(),
                                depthEffect = true,
                                chromaticAberration = true
                            )
                        },
                        onDrawSurface = { drawRect(surfaceColor.copy(0.3f)) }
                    )
            )
            ContentCard(
                icon = EmailIcon,
                socialMedia = "Email",
                socialMediaAccount = "@masdikailhanmansiz@gmail.com",
                modifier = contentCardModifier.clickable(
                    onClick = { Log.i("About Content", "Email") }
                )
            )
            ContentCard(
                icon = LinkedinIcon,
                socialMedia = "LinkedIn",
                socialMediaAccount = "Masdika Ilhan Mansiz",
                modifier = contentCardModifier
                    .clickable(
                        onClick = { Log.i("About Content", "LinkedIn") }
                    )
            )
            ContentCard(
                icon = GithubIcon,
                socialMedia = "GitHub",
                socialMediaAccount = "Masdikaa",
                modifier = contentCardModifier
                    .clickable(
                        onClick = { Log.i("About Content", "GitHub") }
                    )
            )
            ContentCard(
                icon = InstagramIcon,
                socialMedia = "Instagram",
                socialMediaAccount = "Masdikaa",
                modifier = contentCardModifier.clickable(
                    onClick = { Log.i("About Content", "Instagram") }
                )
            )
            Spacer(Modifier.height(10.dp))
        }
        Spacer(Modifier.fillMaxHeight(0.03f))
    }
}

@Preview(
    name = "Light Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "Dark Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun AboutScreenPreview() {
    FighterRankComposeTheme {
        AboutScreen()
    }
}