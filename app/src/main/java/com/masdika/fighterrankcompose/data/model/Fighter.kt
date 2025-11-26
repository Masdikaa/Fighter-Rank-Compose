package com.masdika.fighterrankcompose.data.model

data class Fighter(
    val image: String,
    val name: String,
    val division: String,
    val description: String,
    val wins: Int,
    val losses: Int,
    val draws: Int,
    val strikeAccuracy: Double,
    val takedownAccuracy: Double,
    val knockOutWins: Int,
    val submissionWins: Int,
    val title: String,
)