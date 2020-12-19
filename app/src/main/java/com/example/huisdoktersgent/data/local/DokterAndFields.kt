package com.example.huisdoktersgent.data.local

import androidx.room.Embedded
import androidx.room.Relation

class DokterAndFields (

    @Embedded
    val dokter: DokterEntity,

    @Relation(parentColumn = "recordid", entityColumn = "dokterId")
    val fields: DokterFieldsEntity
    )