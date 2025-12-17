package com.masdika.fighterrankcompose.ui.screens.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.masdika.fighterrankcompose.data.model.Fighter
import com.masdika.fighterrankcompose.data.source.loadFighters
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

sealed interface HomeUIState {
    object Loading : HomeUIState
    data class Success(val fighters: List<Fighter>) : HomeUIState
    data class Error(val message: String) : HomeUIState
}

class HomeViewModel(application: Application) : AndroidViewModel(application) {
    private val _uiState = MutableStateFlow<HomeUIState>(HomeUIState.Loading)
    val uiState: StateFlow<HomeUIState> = _uiState.asStateFlow()

    init {
        getFighters()
    }

    private fun getFighters() {
        _uiState.update { HomeUIState.Loading }
        val fighters = loadFighters(getApplication())
        _uiState.update { HomeUIState.Success(fighters) }
    }
}
