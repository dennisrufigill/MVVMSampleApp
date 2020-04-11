package com.example.recyclerviewmvvmsimplifiedcoding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

//this class is responsible for creating viewmodel instances
@Suppress("UNCHECKED_CAST")
class CharactersViewModelFactory(private val repository: MoviesRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return  CharactersViewModel(repository) as T
    }

}
