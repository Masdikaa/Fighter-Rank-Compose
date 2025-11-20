package com.masdika.fighterrankcompose

import android.os.Bundle
import android.util.Log
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
                    val description =
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n\nUt enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.\n\nDuis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum." +
                                "\n\nLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n\nUt enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.\n\nDuis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum." +
                                "\n\nLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n\nUt enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.\n\nDuis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."

                    val fighterData = Fighter(
                        image = "https://i.postimg.cc/h4zmMmj0/Untitled-design-11.png",
                        name = "Fighter",
                        division = "Lightweight",
                        description = description,
                        wins = 99,
                        loses = 99,
                        draws = 99,
                        strikeAccuracy = 99.0,
                        takedownAccuracy = 99.0,
                        knockOutWins = 99,
                        submissionWins = 99,
                        title = "\"El Macho\""
                    )

                    DetailScreen(
                        fighter = fighterData,
                        onShareButtonClick_Detail = {
                            Log.i(
                                "Detail Screen",
                                "onShareButtonClick"
                            )
                        },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}