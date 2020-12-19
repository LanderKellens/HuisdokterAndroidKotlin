package com.example.huisdoktersgent.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.huisdoktersgent.models.Record

@Dao
interface DokterDao {

    @Transaction
    @Query("select * from dokters")
    fun getAllDokters(): LiveData<List<DokterAndFields>>

    @Transaction
    @Query("select * from dokters where recordid=:id")
    fun getDokter(id: String): LiveData<DokterAndFields>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<DokterEntity>)
}