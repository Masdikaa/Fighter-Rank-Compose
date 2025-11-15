package com.masdika.fighterrankcompose.ui.screens.detail.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil3.compose.AsyncImage
import com.masdika.fighterrankcompose.R
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
    ConstraintLayout(
        modifier = modifier.background(MaterialTheme.colorScheme.primary)
    ) {

        val (
            fighterImageView,
            fighterNameText,
            fighterTitleText,
            fighterDivisionText,
            fighterRecordText,
        ) = createRefs()

        AsyncImage(
            model = fighterImage,
            contentDescription = fighterName + stringResource(R.string.fighter_image),
            placeholder = painterResource(R.drawable.ic_launcher_foreground),
            error = painterResource(R.drawable.ic_launcher_foreground),
            contentScale = ContentScale.Crop,
            modifier = Modifier.constrainAs(fighterImageView) {
                start.linkTo(anchor = parent.start, margin = 10.dp)
                bottom.linkTo(anchor = parent.bottom)
                width = Dimension.value(165.dp)
                height = Dimension.value(250.dp)
            }
        )

        Text(
            text = fighterName.uppercase(),
            fontFamily = BebasNeue,
            fontSize = 22.sp,
            textAlign = TextAlign.Start,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.constrainAs(fighterNameText) {
                top.linkTo(anchor = fighterImageView.top, margin = 5.dp)
                start.linkTo(anchor = fighterImageView.end, margin = 8.dp)
                end.linkTo(anchor = parent.end, margin = 10.dp)
                width = Dimension.fillToConstraints
                height = Dimension.wrapContent
            }
        )

        Text(
            text = fighterTitle.uppercase(),
            fontFamily = MavenPro,
            fontSize = 14.sp,
            textAlign = TextAlign.Start,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.constrainAs(fighterTitleText) {
                top.linkTo(anchor = fighterNameText.bottom)
                start.linkTo(anchor = fighterImageView.end, margin = 8.dp)
                end.linkTo(anchor = parent.end, margin = 10.dp)
                width = Dimension.fillToConstraints
                height = Dimension.wrapContent
            }
        )

        Text(
            text = (fighterDivision + stringResource(R.string.division)).uppercase(),
            fontFamily = BebasNeue,
            fontSize = 14.sp,
            textAlign = TextAlign.Start,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.constrainAs(fighterDivisionText) {
                top.linkTo(anchor = fighterTitleText.bottom)
                start.linkTo(anchor = fighterImageView.end, margin = 8.dp)
                end.linkTo(anchor = parent.end, margin = 10.dp)
                width = Dimension.fillToConstraints
                height = Dimension.wrapContent
            }
        )

        Text(
            text = "$fighterWins-$fighterDraws-$fighterLoses | (W-D-L)",
            fontFamily = BebasNeue,
            fontSize = 18.sp,
            textAlign = TextAlign.Start,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.constrainAs(fighterRecordText) {
                top.linkTo(anchor = fighterDivisionText.bottom)
                start.linkTo(anchor = fighterImageView.end, margin = 8.dp)
                end.linkTo(anchor = parent.end, margin = 10.dp)
                width = Dimension.fillToConstraints
                height = Dimension.wrapContent
            }

        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier
                .constrainAs(createRef()) {
                    top.linkTo(anchor = fighterRecordText.bottom)
                    start.linkTo(anchor = fighterImageView.end, margin = 8.dp)
                    end.linkTo(anchor = parent.end, margin = 10.dp)
                    bottom.linkTo(anchor = parent.bottom)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "$fighterWinByKnockout",
                    fontFamily = BebasNeue,
                    fontSize = 70.sp,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.wrapContentSize()
                )

                HorizontalDivider(
                    modifier = Modifier.width(70.dp),
                    thickness = 3.dp,
                    color = MainRed.copy(0.7f)
                )

                Text(
                    text = stringResource(R.string.wins_by_knockout).uppercase(),
                    fontFamily = BebasNeue,
                    fontSize = 11.sp,
                    textAlign = TextAlign.Center,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.wrapContentSize()
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "$fighterWinBySubmission",
                    fontFamily = BebasNeue,
                    fontSize = 70.sp,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.wrapContentSize()
                )

                HorizontalDivider(
                    modifier = Modifier.width(70.dp),
                    thickness = 3.dp,
                    color = MainRed.copy(0.7f)
                )

                Text(
                    text = stringResource(R.string.wins_by_submission).uppercase(),
                    fontFamily = BebasNeue,
                    fontSize = 11.sp,
                    textAlign = TextAlign.Center,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.wrapContentSize()
                )
            }
        }

    }
}

@Preview(
    name = "Fighter Overview Light",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    widthDp = 540,
)
@Preview(
    name = "Fighter Overview Dark",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    widthDp = 540,
)
@Composable
private fun FighterOverviewPreview() {
    FighterRankComposeTheme {
        FighterOverview(
            fighterImage = "",
            fighterName = "Masdika Ilhan Mansiz",
            fighterTitle = "\"El Macho\"",
            fighterDivision = "Lightweight",
            fighterWins = 99,
            fighterDraws = 99,
            fighterLoses = 99,
            fighterWinByKnockout = 99,
            fighterWinBySubmission = 99,
        )
    }
}