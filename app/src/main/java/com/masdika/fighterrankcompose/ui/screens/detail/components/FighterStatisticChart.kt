package com.masdika.fighterrankcompose.ui.screens.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.masdika.fighterrankcompose.R
import com.masdika.fighterrankcompose.ui.theme.BebasNeue
import com.masdika.fighterrankcompose.ui.theme.FighterRankComposeTheme
import com.masdika.fighterrankcompose.ui.theme.MainRed
import ir.ehsannarmani.compose_charts.PieChart
import ir.ehsannarmani.compose_charts.models.Pie
import kotlin.math.roundToInt

@Composable
fun FighterStatisticChart(
    fighterStrikeAccuracy: Double,
    fighterTakedownAccuracy: Double,
    modifier: Modifier = Modifier
) {

    var strikeAccuracyData by remember {
        mutableStateOf(
            listOf(
                Pie(
                    label = "Striking Accuracy",
                    data = fighterStrikeAccuracy,
                    color = MainRed.copy(alpha = 0.8f),
                    selectedColor = MainRed
                ),

                Pie(
                    label = "Striking Accuracy",
                    data = 100 - fighterStrikeAccuracy,
                    color = Color.Gray,
                    selectedColor = Color.LightGray
                )
            )
        )
    }

    var takedownAccuracyData by remember {
        mutableStateOf(
            listOf(
                Pie(
                    label = "Takedown Accuracy",
                    data = fighterTakedownAccuracy,
                    color = MainRed.copy(alpha = 0.8f),
                    selectedColor = MainRed
                ),

                Pie(
                    label = "Takedown Accuracy",
                    data = 100 - fighterTakedownAccuracy,
                    color = Color.Gray,
                    selectedColor = Color.LightGray
                )
            )
        )
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                PieChart(
                    data = strikeAccuracyData,
                    onPieClick = {
                        val pieIndex = strikeAccuracyData.indexOf(it)
                        strikeAccuracyData = strikeAccuracyData.mapIndexed { mapIndex, pie ->
                            val isTargetPie = mapIndex == pieIndex
                            val newSelectedState = if (isTargetPie) !it.selected else false
                            pie.copy(selected = newSelectedState)
                        }
                    },
                    spaceDegree = 3f,
                    style = Pie.Style.Stroke(width = 30.dp),
                    modifier = Modifier
                        .size(150.dp)
                        .rotate(-90f),
                )

                Text(
                    text = "${fighterStrikeAccuracy.roundToInt()}%",
                    fontFamily = BebasNeue,
                    fontSize = 18.sp
                )
            }

            Spacer(Modifier.height(8.dp))

            Text(
                text = stringResource(R.string.striking_accuracy),
                fontFamily = BebasNeue,
                fontSize = 18.sp,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = true
                    ),
                    lineHeightStyle = LineHeightStyle(
                        trim = LineHeightStyle.Trim.Both,
                        alignment = LineHeightStyle.Alignment.Top,
                    )
                ),
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                PieChart(
                    data = takedownAccuracyData,
                    onPieClick = {
                        val pieIndex = takedownAccuracyData.indexOf(it)
                        takedownAccuracyData = takedownAccuracyData.mapIndexed { mapIndex, pie ->
                            val isTargetPie = mapIndex == pieIndex
                            val newSelectedState = if (isTargetPie) !it.selected else false
                            pie.copy(selected = newSelectedState)
                        }
                    },
                    spaceDegree = 3f,
                    style = Pie.Style.Stroke(width = 30.dp),
                    modifier = Modifier
                        .size(150.dp)
                        .rotate(-90f),
                )

                Text(
                    text = "${fighterTakedownAccuracy.roundToInt()}%",
                    fontFamily = BebasNeue,
                    fontSize = 18.sp
                )
            }

            Spacer(Modifier.height(8.dp))

            Text(
                text = stringResource(R.string.takedown_accuracy),
                fontFamily = BebasNeue,
                fontSize = 18.sp,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = true
                    ),
                    lineHeightStyle = LineHeightStyle(
                        trim = LineHeightStyle.Trim.Both,
                        alignment = LineHeightStyle.Alignment.Top,
                    )
                ),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FighterStatisticChartPreview() {
    FighterRankComposeTheme {
        FighterStatisticChart(
            fighterStrikeAccuracy = 87.9,
            fighterTakedownAccuracy = 41.2,
        )
    }
}