package com.example.huisdoktersgent.repos

import android.content.Context
import com.example.huisdoktersgent.data.local.AppDatabase
import com.example.huisdoktersgent.data.local.DokterLocalDataSource
import com.example.huisdoktersgent.data.remote.DokterRemoteDataSource
import com.example.huisdoktersgent.data.remote.GhentApi

class RepositoryUtils {
    companion object {
        fun createDokterRepository(context: Context): DokterRepository {
            val database = AppDatabase.getDatabase(context)
            val localDataSource = DokterLocalDataSource(database.dokterDao(), database.dokterFieldsDao())
            val remoteDataSource = DokterRemoteDataSource(GhentApi.apiService)

            return DokterRepository(localDataSource, remoteDataSource)
        }
    }
}