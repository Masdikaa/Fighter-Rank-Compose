package com.masdika.fighterrankcompose.ui.screens.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.masdika.fighterrankcompose.data.model.Fighter
import com.masdika.fighterrankcompose.data.source.loadFighters
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

sealed interface DetailUIState {
    data class Success(val fighter: Fighter) : DetailUIState
    data class Error(val message: String) : DetailUIState
    object Loading : DetailUIState
}

class DetailViewModel(application: Application) : AndroidViewModel(application) {
    private val _uiState = MutableStateFlow<DetailUIState>(DetailUIState.Loading)
    val uiState: StateFlow<DetailUIState> = _uiState.asStateFlow()

    private val fighters: List<Fighter> = loadFighters(getApplication())

    fun findFighterByName(name: String) {
        _uiState.update { DetailUIState.Loading }
        val fighter = fighters.find { it.name == name }

        if (fighter != null) {
            _uiState.update { DetailUIState.Success(fighter) }
        } else {
            _uiState.update { DetailUIState.Error("Fighter not found !") }
        }
    }

}