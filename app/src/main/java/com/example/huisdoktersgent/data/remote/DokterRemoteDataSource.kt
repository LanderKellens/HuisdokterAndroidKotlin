package com.example.huisdoktersgent.data.remote

import com.example.huisdoktersgent.BaseDataSource

class DokterRemoteDataSource(val apiService: GhentApiService): BaseDataSource() {

    suspend fun getDokters() = getResult { apiService.getDokters() }
}