package com.example.huisdoktersgent.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.huisdoktersgent.data.remote.GhentApiService
import com.example.huisdoktersgent.repos.DokterRepository
import java.lang.IllegalArgumentException

class DokterOverviewViewModelFactory(private val repository: DokterRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DokterOverviewViewModel::class.java)){
            return DokterOverviewViewModel(
                repository
            ) as T
        }
        throw IllegalArgumentException("Unknown Viewmodel class")
    }
}