package com.example.kotlinaccount.database

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class ItemRecordRepository(private val itemRecordDao:ItemRecordDao) {
    val allRecords: Flow<List<ItemRecord>> = itemRecordDao.getAllRecord()


    @WorkerThread
    suspend fun insert(itemRecord: ItemRecord) {
        itemRecordDao.insertItemRecord(itemRecord)
    }
}