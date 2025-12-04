package com.masdika.fighterrankcompose.ui.screens.about

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.masdika.fighterrankcompose.data.model.SocialMediaItem
import com.masdika.fighterrankcompose.data.source.SocialMediaDataProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

sealed interface AboutUIState {
    object Loading : AboutUIState
    data class Success(val socialMediaItem: List<SocialMediaItem>) : AboutUIState
    data class Error(val message: String) : AboutUIState
}

class AboutViewModel(application: Application) : AndroidViewModel(application) {
    private val _uiState = MutableStateFlow<AboutUIState>(AboutUIState.Loading)
    val uiState: StateFlow<AboutUIState> = _uiState.asStateFlow()

    init {
        getSocialMediaItems()
    }

    private fun getSocialMediaItems() {
        val items = SocialMediaDataProvider.socialMediaItems
        _uiState.value = AboutUIState.Success(items)
    }
}