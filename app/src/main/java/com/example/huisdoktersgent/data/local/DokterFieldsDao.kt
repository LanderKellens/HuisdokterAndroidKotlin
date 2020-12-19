package com.example.huisdoktersgent.data.local

import androidx.room.*

@Dao
interface DokterFieldsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(List: List<DokterFieldsEntity>)
}