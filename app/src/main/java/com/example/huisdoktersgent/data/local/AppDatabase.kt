package com.example.huisdoktersgent.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.huisdoktersgent.models.Fields
import com.example.huisdoktersgent.models.Record

@Database(entities = [DokterEntity::class, DokterFieldsEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase:RoomDatabase() {

    abstract fun dokterDao(): DokterDao
    abstract fun dokterFieldsDao(): DokterFieldsDao

    companion object{
        @Volatile
        private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
                instance ?: synchronized(this) { instance ?: buildDatabase(context).also { instance = it} }

        private fun buildDatabase(appContext: Context) =
                Room.databaseBuilder(appContext, AppDatabase::class.java, "dokterDB")
                        .fallbackToDestructiveMigration()
                        .build()
    }
}