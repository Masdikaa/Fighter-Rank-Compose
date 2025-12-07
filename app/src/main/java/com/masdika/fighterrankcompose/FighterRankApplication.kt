package com.masdika.fighterrankcompose

import android.app.Application
import com.masdika.fighterrankcompose.data.local.FighterRankDatabase
import com.masdika.fighterrankcompose.data.repositories.FighterRepository

class FighterRankApplication : Application() {
    val database by lazy { FighterRankDatabase.getInstance(this) }
    val repository by lazy { FighterRepository.getInstance(database.fighterDao()) }
}

// Application custom untuk menjadi "wadah" bagi instance singleton dari database dan repository