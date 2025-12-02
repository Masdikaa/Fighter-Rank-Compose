package com.masdika.fighterrankcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.masdika.fighterrankcompose.navigation.AppNavigation
import com.masdika.fighterrankcompose.ui.theme.FighterRankComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FighterRankComposeTheme {
                val navController = rememberNavController()
                val context = LocalContext.current
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    AppNavigation(
                        context = context,
                        navController = navController,
                    )
                }
            }
        }
    }
}
//#FF121316 BG Dark
//#FFFAF9FD BG Light

//#FF1B1B1F OnBG Dark
//#FFE3E2E6 onBG Light