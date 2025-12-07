package com.masdika.fighterrankcompose.ui.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.masdika.fighterrankcompose.data.model.Fighter
import com.masdika.fighterrankcompose.data.repositories.FighterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

// Defining state possibilities for UI
sealed interface DetailUIState {
    data class Success(val fighter: Fighter) : DetailUIState
    data class Error(val message: String) : DetailUIState
    object Loading : DetailUIState
}

class DetailViewModel(private val repository: FighterRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<DetailUIState>(DetailUIState.Loading)
    val uiState: StateFlow<DetailUIState> = _uiState.asStateFlow()

    fun findFighterById(id: Int) {
        viewModelScope.launch {
            repository.getFighterById(id)
                .catch { exception ->
                    _uiState.value = DetailUIState.Error(exception.message.toString())
                }
                .collect { fighter ->
                    _uiState.value = DetailUIState.Success(fighter)
                }
        }
    }
//
//    private val fighters: List<Fighter> = loadFighters(getApplication<Application>().applicationContext)
//
//    fun findFighterByName(name: String) {
//        _uiState.update { DetailUIState.Loading }
//        val fighter = fighters.find { it.name == name }
//
//        if (fighter != null) {
//            _uiState.update { DetailUIState.Success(fighter) }
//        } else {
//            _uiState.update { DetailUIState.Error("Fighter not found !") }
//        }
//    }
}