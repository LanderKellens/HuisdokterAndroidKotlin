package com.example.huisdoktersgent.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.huisdoktersgent.repos.DokterRepository
import java.lang.IllegalArgumentException

class DokterDetailViewmodelFactory(private val repository: DokterRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DokterDetailViewModel::class.java)){
            return DokterDetailViewModel(
                    repository
            ) as T
        }
        throw IllegalArgumentException("Unknown Viewmodel class")
    }
}