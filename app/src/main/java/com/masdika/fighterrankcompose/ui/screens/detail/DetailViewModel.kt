package com.masdika.fighterrankcompose.ui.screens.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.masdika.fighterrankcompose.data.model.Fighter
import com.masdika.fighterrankcompose.data.source.loadFighters
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

// Defining state possibilities for UI
sealed interface DetailUIState {
    data class Success(val fighter: Fighter) : DetailUIState
    data class Error(val message: String) : DetailUIState
    object Loading : DetailUIState
}

// ViewModel class
class DetailViewModel(application: Application) : AndroidViewModel(application) {
    // Stateflow to save UI State
    private val _uiState = MutableStateFlow<DetailUIState>(DetailUIState.Loading)
    val uiState: StateFlow<DetailUIState> = _uiState.asStateFlow()

    private val fighters: List<Fighter> = loadFighters(getApplication<Application>().applicationContext)

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

/*
1. sealed interface DetailUiState: Ini adalah cara modern untuk merepresentasikan semua kemungkinan kondisi UI Anda.
   Layar detail bisa dalam kondisi Loading (menunggu data), Success (berhasil mendapatkan data fighter), atau Error (terjadi masalah). Ini jauh lebih aman daripada menggunakan banyak Boolean (misal: isLoading, isError).
2. DetailViewModel akan mewarisi AndroidViewModel bukan ViewModel biasa karena membutuhkan context untuk memanggil loadFighters
3. `_uiState` dan `uiState` adalah pattern umum :
   `_uiState` bersifat private dan mutable yang hanya bisa diubah oleh viewmodel
   `uiState` bersifat public dan immutable yang diakses oleh UI untuk mendapatkan data
*/