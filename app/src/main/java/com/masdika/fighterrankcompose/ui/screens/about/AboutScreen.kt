package com.masdika.fighterrankcompose.ui.screens.about

import android.content.Intent
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import com.kyant.backdrop.backdrops.rememberLayerBackdrop
import com.masdika.fighterrankcompose.R
import com.masdika.fighterrankcompose.data.model.SocialMediaItem
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
import com.masdika.fighterrankcompose.ui.theme.glassmorphism
import com.masdika.fighterrankcompose.utils.openUrl

@Composable
fun AboutScreen(
    uiState: AboutUIState,
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        when (uiState) {
            is AboutUIState.Loading -> {
                CircularProgressIndicator(color = MainRed)
            }

            is AboutUIState.Success -> {
                val backdrop = rememberLayerBackdrop()
                val surfaceColor = MaterialTheme.colorScheme.background.copy(0.2f)
                val context = LocalContext.current

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
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
                            model = stringResource(R.string.about_profile_url),
                            modifier = Modifier.glassmorphism(
                                backdrop = backdrop,
                                surfaceColor = surfaceColor,
                                shape = CircleShape,
                                depthEffect = false,
                                chromaticAberration = false
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
                            .glassmorphism(backdrop, surfaceColor, blurRadius = 4f)
                    ) {
                        val contentCardModifier: Modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(horizontal = 10.dp)
                            .padding(top = 10.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .glassmorphism(backdrop, surfaceColor.copy(0.3f))

                        ContentAbout(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp)
                                .padding(top = 10.dp)
                                .glassmorphism(backdrop, surfaceColor.copy(0.3f))
                        )
                        uiState.socialMediaItem.forEach { item ->
                            ContentCard(
                                icon = item.icon,
                                socialMediaName = item.socialMediaName,
                                socialMediaAccount = item.socialMediaAccount,
                                modifier = contentCardModifier.clickable {
                                    item.url?.let { url ->
                                        context.openUrl(url)
                                    } ?: run {
                                        if (item.socialMediaName == "Email") {
                                            val intent = Intent(Intent.ACTION_SENDTO).apply {
                                                data = "mailto:${item.socialMediaAccount}".toUri()
                                                putExtra(Intent.EXTRA_SUBJECT, "Whatsapp Masdika")
                                            }
                                            try {
                                                context.startActivity(intent)
                                                Log.i(
                                                    "AboutScreen",
                                                    "Email card clicked. Intent to open email client!."
                                                )
                                            } catch (e: Exception) {
                                                e.printStackTrace()
                                            }
                                        } else {
                                            Log.i(
                                                "contentCard",
                                                "No url passed"
                                            )
                                        }
                                    }
                                }
                            )
                        }
                        Spacer(Modifier.height(10.dp))
                    }
                    Spacer(Modifier.fillMaxHeight(0.03f))
                }
            }

            is AboutUIState.Error -> {
                Text(
                    text = "About Description Not Found",
                    fontFamily = BebasNeue,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.onBackground,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = true
                        ), lineHeightStyle = LineHeightStyle(
                            trim = LineHeightStyle.Trim.Both,
                            alignment = LineHeightStyle.Alignment.Top,
                        )
                    ),
                )
            }
        }
    }
}

@Preview(
    name = "About Screen Loading Light Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "About Screen Loading Dark Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun AboutScreenLoadingPreview() {
    FighterRankComposeTheme {
        AboutScreen(
            uiState = AboutUIState.Loading
        )
    }
}

@Preview(
    name = "About Screen Success Light Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "About Screen Success Dark Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun AboutScreenSuccessPreview() {
    FighterRankComposeTheme {
        val mockSocialMediaItem = listOf(
            SocialMediaItem(
                icon = EmailIcon,
                socialMediaName = "Email",
                socialMediaAccount = "aboutscreen@gmail.com"
            ),
            SocialMediaItem(
                icon = GithubIcon,
                socialMediaName = "GitHub",
                socialMediaAccount = "Masdikaa"
            ),
            SocialMediaItem(
                icon = LinkedinIcon,
                socialMediaName = "LinkedIn",
                socialMediaAccount = "Masdika Ilhan Mansiz"
            ),
            SocialMediaItem(
                icon = InstagramIcon,
                socialMediaName = "Instagram",
                socialMediaAccount = "ibwdvncjk"
            ),
        )
        AboutScreen(
            uiState = AboutUIState.Success(
                socialMediaItem = mockSocialMediaItem
            )
        )
    }
}

@Preview(
    name = "About Screen Error Light Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "About Screen Error Dark Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun AboutScreenErrorPreview() {
    FighterRankComposeTheme {
        AboutScreen(
            uiState = AboutUIState.Error(
                message = "Description not found"
            )
        )
    }
}
