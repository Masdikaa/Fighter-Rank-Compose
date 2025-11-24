package com.masdika.fighterrankcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.masdika.fighterrankcompose.navigation.AppNavigation
import com.masdika.fighterrankcompose.navigation.Screen
import com.masdika.fighterrankcompose.ui.components.TopAppBarHome
import com.masdika.fighterrankcompose.ui.theme.FighterRankComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FighterRankComposeTheme {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                Scaffold(
                    topBar = {
                        val isHomeScreen = currentDestination?.hasRoute<Screen.Home>() == true
                        if (isHomeScreen) {
                            TopAppBarHome({ Log.i("TopAppBarHome", "onFighterIconClick") })
                        }
                    },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    AppNavigation(
                        navController = navController,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}