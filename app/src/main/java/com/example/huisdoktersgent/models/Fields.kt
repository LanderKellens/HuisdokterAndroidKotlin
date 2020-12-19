package com.example.huisdoktersgent.models


import android.os.Parcelable
import com.example.huisdoktersgent.data.local.DokterFieldsEntity
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Fields(
    val gemeente: String,
    val globalid: String,
    val huisnr: String,
    val naam: String,
    val postcode: String,
    val straat: String,
    val type: String
): Parcelable {
    fun toDatabaseModel(dokterId: String): DokterFieldsEntity {
        return DokterFieldsEntity(gemeente, globalid, huisnr, naam, postcode, straat, type, dokterId)
    }
}