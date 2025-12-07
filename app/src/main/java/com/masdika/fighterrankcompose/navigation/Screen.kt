package com.masdika.fighterrankcompose.navigation

import kotlinx.serialization.Serializable

sealed interface Screen {
    @Serializable
    data object Home : Screen

    @Serializable
    data class Detail(val fighterId: Int)

    @Serializable
    data object About : Screen
}