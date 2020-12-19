package com.example.huisdoktersgent.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.huisdoktersgent.data.local.DokterAndFields
import com.example.huisdoktersgent.repos.DokterRepository

class DokterDetailViewModel(private val repository: DokterRepository) : ViewModel() {
    private lateinit var _dokter : LiveData<DokterAndFields>
    val dokter : LiveData<DokterAndFields>
        get() = _dokter

    fun updateDokter(id: String){
        _dokter = repository.getDokter(id)
    }
}