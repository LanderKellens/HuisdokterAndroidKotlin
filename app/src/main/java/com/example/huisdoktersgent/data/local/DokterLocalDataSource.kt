package com.example.huisdoktersgent.data.local

import com.example.huisdoktersgent.models.Record

class DokterLocalDataSource(private val dokterDao: DokterDao, private val dokterFieldsDao: DokterFieldsDao) {

    fun getDokters() = dokterDao.getAllDokters()

    fun getDokter(id: String) = dokterDao.getDokter(id)

    fun saveDokters(list: List<Record>){
        val dokterList = ArrayList<DokterEntity>()
        list.forEach { dokter -> dokterList.add(dokter.toDatabaseModel()) }
        dokterDao.insertAll(dokterList)

        val fieldsList = ArrayList<DokterFieldsEntity>()
        list.forEach { dokter -> fieldsList.add(dokter.fields.toDatabaseModel(dokter.recordid)) }
        dokterFieldsDao.insertAll(fieldsList)
    }
}