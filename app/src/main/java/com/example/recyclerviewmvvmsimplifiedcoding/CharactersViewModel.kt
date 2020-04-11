package com.example.recyclerviewmvvmsimplifiedcoding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job

class CharactersViewModel(private val repository: MoviesRepository) : ViewModel() {

    private val _characters = MutableLiveData<List<CharactersItem>>()
    private lateinit var job: Job

    val characters: LiveData<List<CharactersItem>>
    get() = _characters

// we are fetching characters in IO thread  and making changes in Live Data in Main THREAD. B/C in IO app will crash
     fun getMovies(){
    job = Coroutines.ioThenMain(
        {repository.getMovies()},
        {_characters.value = it}
    )

    }

//we need to cancel the job as well. If the job is initializes, it will be cancelled.
    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }
}
//This viewModel will communicate with our Repository