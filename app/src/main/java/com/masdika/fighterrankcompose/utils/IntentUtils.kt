package com.masdika.fighterrankcompose.utils

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.net.toUri

fun Context.openUrl(url: String) {
    val intent = Intent(Intent.ACTION_VIEW, url.toUri())
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    try {
        startActivity(intent)
    } catch (e: Exception) {
        e.printStackTrace()
        Log.e("Context.openUrl", e.toString())
    }
}

fun Context.shareContent(fighterName: String, fighterDescription: String) {
    val content = "$fighterName\n$fighterDescription"
    val sendIntent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, content)
    }
    val shareIntent = Intent.createChooser(sendIntent, "Share via...")
    startActivity(shareIntent)
}