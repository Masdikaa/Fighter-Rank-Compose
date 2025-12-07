package com.masdika.fighterrankcompose.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.masdika.fighterrankcompose.data.repositories.FighterRepository
import com.masdika.fighterrankcompose.ui.screens.detail.DetailViewModel
import com.masdika.fighterrankcompose.ui.screens.home.HomeViewModel

class ViewModelFactory(private val repository: FighterRepository) :

    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

}

// ViewModel yang memiliki parameter di konstruktornya (seperti HomeViewModel(repository: FighterRepository)) memerlukan sebuah "Factory" untuk bisa dibuat.