package com.example.huisdoktersgent.models


import android.os.Parcelable
import com.example.huisdoktersgent.data.local.DokterEntity
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Record(
    val datasetid: String,
    val fields: Fields,
    val recordid: String
): Parcelable {
    fun toDatabaseModel(): DokterEntity {
        return DokterEntity(recordid)
    }
}