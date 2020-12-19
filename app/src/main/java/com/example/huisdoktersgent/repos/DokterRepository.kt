package com.example.huisdoktersgent.repos

import com.example.huisdoktersgent.data.local.DokterLocalDataSource
import com.example.huisdoktersgent.data.remote.DokterRemoteDataSource
import com.example.huisdoktersgent.utils.performGetOperation

class DokterRepository(private val dokterLocalDataSource: DokterLocalDataSource, private val dokterRemoteDataSource: DokterRemoteDataSource) {

    fun getDokter(id: String) = dokterLocalDataSource.getDokter(id)

    fun getDokter() = performGetOperation(
            databaseQuery = {dokterLocalDataSource.getDokters()},
            networkCall = {dokterRemoteDataSource.getDokters()},
            saveCallResult = {dokterLocalDataSource.saveDokters(it.records)}
    )
}