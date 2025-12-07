package com.masdika.fighterrankcompose.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.masdika.fighterrankcompose.data.model.Fighter
import com.masdika.fighterrankcompose.data.repositories.FighterRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

sealed interface HomeUIState {
    object Loading : HomeUIState
    data class Success(val fighters: List<Fighter>) : HomeUIState
    data class Error(val message: String) : HomeUIState
}

class HomeViewModel(repository: FighterRepository) : ViewModel() {

    val uiState: StateFlow<HomeUIState> = repository.getAllFighters()
        .map { fighters ->
            if (fighters.isNotEmpty()) {
                HomeUIState.Success(fighters)
            } else {
                HomeUIState.Loading
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = HomeUIState.Loading
        )
//    private val _uiState = MutableStateFlow<HomeUIState>(HomeUIState.Loading)
//    val uiState: StateFlow<HomeUIState> = _uiState.asStateFlow()
//
//    init {
//        getFighters()
//    }
//
//    private fun getFighters() {
//        _uiState.update { HomeUIState.Loading }
//        val fighters = loadFighters(getApplication<Application>().applicationContext)
//        _uiState.update { HomeUIState.Success(fighters) }
//    }
}
