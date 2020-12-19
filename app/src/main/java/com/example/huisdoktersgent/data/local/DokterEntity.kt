package com.example.huisdoktersgent.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dokters")
class DokterEntity (
        @PrimaryKey
        val recordid: String
)