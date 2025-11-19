package com.masdika.fighterrankcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.masdika.fighterrankcompose.data.model.Fighter
import com.masdika.fighterrankcompose.ui.screens.detail.DetailScreen
import com.masdika.fighterrankcompose.ui.theme.FighterRankComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FighterRankComposeTheme {
                Scaffold(
//                    topBar = {
//                        TopAppBarHome({ Log.i("TopAppBarHome", "onFighterIconClick") })
//                    },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
//                    HomeScreen(modifier = Modifier.padding(innerPadding))
                    val fighterData = Fighter(
                        image = "https://i.postimg.cc/h4zmMmj0/Untitled-design-11.png",
                        name = "Fighter",
                        division = "Lightweight",
                        description = "Description",
                        wins = 99,
                        loses = 99,
                        draws = 99,
                        strikeAccuracy = 99,
                        takedownAccuracy = 99,
                        knockOutWins = 99,
                        submissionWins = 99,
                        title = "\"Jagoan\""
                    )
                    DetailScreen(
                        fighter = fighterData,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}