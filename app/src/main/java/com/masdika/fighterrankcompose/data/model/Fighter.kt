package com.masdika.fighterrankcompose.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fighters")
data class Fighter(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
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
    val p4pRank: Int,
)