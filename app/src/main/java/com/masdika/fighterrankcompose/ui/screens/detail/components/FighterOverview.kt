package com.masdika.fighterrankcompose.ui.screens.detail.components

import android.content.res.Configuration
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
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
import coil3.compose.AsyncImage
import com.masdika.fighterrankcompose.R
import com.masdika.fighterrankcompose.data.source.loadFighters
import com.masdika.fighterrankcompose.ui.theme.BebasNeue
import com.masdika.fighterrankcompose.ui.theme.FighterRankComposeTheme
import com.masdika.fighterrankcompose.ui.theme.MainRed
import com.masdika.fighterrankcompose.ui.theme.MavenPro

@Composable
fun FighterOverview(
    fighterImage: String,
    fighterName: String,
    fighterTitle: String,
    fighterDivision: String,
    fighterWins: Int,
    fighterDraws: Int,
    fighterLoses: Int,
    fighterWinByKnockout: Int,
    fighterWinBySubmission: Int,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier
    ) {
        val fighterImageModifier: Modifier = if (isSystemInDarkTheme()) {
            Modifier
                .fillMaxHeight(0.95f)
                .fillMaxWidth(0.42f)
                .shadow(
                    elevation = 100.dp,
                    clip = true,
                    spotColor = Color.Blue
                )
        } else {
            Modifier
                .fillMaxHeight(0.95f)
                .fillMaxWidth(0.42f)
                .shadow(
                    elevation = 100.dp,
                    clip = true,
                    spotColor = MainRed.copy(alpha = 0.8f)
                )
        }
        AsyncImage(
            model = fighterImage,
            contentDescription = fighterName + stringResource(R.string.fighter_image),
            placeholder = painterResource(R.drawable.ic_launcher_foreground),
            error = painterResource(R.drawable.ic_launcher_foreground),
            contentScale = ContentScale.Fit,
            alignment = Alignment.BottomCenter,
            modifier = fighterImageModifier
        )
        Spacer(Modifier.width(10.dp))
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.9f)
        ) {
            Text(
                text = fighterName.uppercase(),
                fontFamily = BebasNeue,
                fontSize = 24.sp,
                textAlign = TextAlign.Start,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.ExtraBold,
            )
            if (fighterTitle.isNotEmpty()) {
                Text(
                    text = fighterTitle.uppercase(),
                    fontFamily = MavenPro,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.onBackground,
                )
            }
            Text(
                text = (fighterDivision + " " + stringResource(R.string.division)).uppercase(),
                fontFamily = BebasNeue,
                fontSize = 20.sp,
                textAlign = TextAlign.Start,
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
                )
            )
            Text(
                text = ("${fighterWins}-${fighterDraws}-${fighterLoses} (W-D-L)"),
                fontFamily = BebasNeue,
                fontSize = 20.sp,
                textAlign = TextAlign.Start,
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
                )
            )
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxSize()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "$fighterWinByKnockout",
                        fontFamily = BebasNeue,
                        fontSize = 70.sp,
                        color = MaterialTheme.colorScheme.onBackground,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = true
                            ), lineHeightStyle = LineHeightStyle(
                                trim = LineHeightStyle.Trim.Both,
                                alignment = LineHeightStyle.Alignment.Top,
                            )
                        )
                    )
                    HorizontalDivider(
                        modifier = Modifier.width(70.dp), thickness = 3.dp, color = MainRed
                    )
                    Spacer(Modifier.height(10.dp))
                    Text(
                        text = stringResource(R.string.wins_by_knockout).uppercase(),
                        fontFamily = BebasNeue,
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        color = MaterialTheme.colorScheme.onBackground,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = true
                            ), lineHeightStyle = LineHeightStyle(
                                trim = LineHeightStyle.Trim.Both,
                                alignment = LineHeightStyle.Alignment.Top,
                            )
                        )
                    )
                }
                Spacer(Modifier.width(20.dp))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "$fighterWinBySubmission",
                        fontFamily = BebasNeue,
                        fontSize = 70.sp,
                        color = MaterialTheme.colorScheme.onBackground,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = true
                            ), lineHeightStyle = LineHeightStyle(
                                trim = LineHeightStyle.Trim.Both,
                                alignment = LineHeightStyle.Alignment.Top,
                            )
                        )
                    )
                    HorizontalDivider(
                        modifier = Modifier.width(70.dp), thickness = 3.dp, color = MainRed
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = stringResource(R.string.wins_by_submission).uppercase(),
                        fontFamily = BebasNeue,
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        color = MaterialTheme.colorScheme.onBackground,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = true
                            ), lineHeightStyle = LineHeightStyle(
                                trim = LineHeightStyle.Trim.Both,
                                alignment = LineHeightStyle.Alignment.Top,
                            )
                        )
                    )
                }
            }
        }
    }
}

@Preview(
    name = "Fighter Overview Light",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    heightDp = 300,
    widthDp = 540,
)
@Preview(
    name = "Fighter Overview Dark",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    widthDp = 540,
    heightDp = 300,
)
@Composable
private fun FighterOverviewPreview() {
    val fighters = loadFighters(LocalContext.current)
    val fighter = fighters.getOrNull(5)
    FighterRankComposeTheme {
        FighterOverview(
            fighterImage = fighter!!.image,
            fighterName = fighter.name,
            fighterTitle = fighter.title,
            fighterDivision = fighter.division,
            fighterWins = fighter.wins,
            fighterDraws = fighter.draws,
            fighterLoses = fighter.loses,
            fighterWinByKnockout = fighter.knockOutWins,
            fighterWinBySubmission = fighter.submissionWins,
        )
    }
}