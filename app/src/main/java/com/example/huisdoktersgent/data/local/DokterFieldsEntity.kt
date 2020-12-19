package com.example.huisdoktersgent.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(tableName = "dokterFields", foreignKeys = arrayOf(
        ForeignKey(
                entity = DokterEntity::class,
                parentColumns = arrayOf("recordid"),
                childColumns = arrayOf("dokterId"),
                onDelete = ForeignKey.CASCADE
        )
))
class DokterFieldsEntity (
        val gemeente: String,
        val globalid: String,
        val huisnr: String,
        val naam: String,
        val postcode: String,
        val straat: String,
        val type: String,
        @ColumnInfo(name = "dokterId", index = true)
        var dokterId: String?
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}