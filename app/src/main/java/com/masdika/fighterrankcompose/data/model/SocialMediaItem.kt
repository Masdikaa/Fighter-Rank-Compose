package com.masdika.fighterrankcompose.data.model

import androidx.compose.ui.graphics.vector.ImageVector

data class SocialMediaItem(
    val icon: ImageVector,
    val socialMediaName: String,
    val socialMediaAccount: String,
    val url: String? = null
)