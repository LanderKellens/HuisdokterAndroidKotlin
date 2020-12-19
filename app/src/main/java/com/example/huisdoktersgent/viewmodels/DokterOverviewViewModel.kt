package com.example.huisdoktersgent.viewmodels

import androidx.lifecycle.ViewModel
import com.example.huisdoktersgent.repos.DokterRepository

class DokterOverviewViewModel(repository: DokterRepository): ViewModel() {
    val dokters = repository.getDokter()
}