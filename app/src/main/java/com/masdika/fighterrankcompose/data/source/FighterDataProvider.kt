package com.masdika.fighterrankcompose.data.source

import android.content.Context
import com.masdika.fighterrankcompose.R
import com.masdika.fighterrankcompose.data.model.Fighter

fun loadFighters(context: Context): List<Fighter> {
    val r = context.resources

    val names = r.getStringArray(R.array.fighter_names)
    val divisions = r.getStringArray(R.array.fighter_divisions)
    val titles = r.getStringArray(R.array.fighter_titles)
    val images = r.getStringArray(R.array.fighter_images)
    val descriptions = r.getStringArray(R.array.fighter_descriptions)
    val wins = r.getIntArray(R.array.fighter_wins)
    val loses = r.getIntArray(R.array.fighter_loses)
    val draws = r.getIntArray(R.array.fighter_draws)
    val strikeAcc = r.getIntArray(R.array.fighter_strike_accuracy)
    val tdAcc = r.getIntArray(R.array.fighter_takedown_accuracy)
    val koWins = r.getIntArray(R.array.fighter_ko_wins)
    val subWins = r.getIntArray(R.array.fighter_sub_wins)

    val size = names.size
    return List(size) { i ->
        Fighter(
            image = images[i],
            name = names[i],
            division = divisions[i],
            description = descriptions[i],
            wins = wins[i],
            loses = loses[i],
            draws = draws[i],
            strikeAccuracy = strikeAcc[i].toDouble(),
            takedownAccuracy = tdAcc[i].toDouble(),
            knockOutWins = koWins[i],
            submissionWins = subWins[i],
            title = titles[i]
        )
    }
}
