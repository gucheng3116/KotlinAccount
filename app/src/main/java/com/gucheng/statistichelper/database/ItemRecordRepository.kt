package com.gucheng.statistichelper.database

import android.util.Log
import androidx.annotation.WorkerThread
import com.gucheng.statistichelper.Utils
import com.gucheng.statistichelper.database.dao.ItemRecordDao
import com.gucheng.statistichelper.database.entity.ItemRecord
import kotlinx.coroutines.flow.Flow

class ItemRecordRepository(private val itemRecordDao: ItemRecordDao) {
    val allRecords: Flow<List<ItemRecord>> = itemRecordDao.getAllRecord()



    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(itemRecord: ItemRecord) {
        Log.d(
            "gucheng",
            "insertRecord thread id is " + Thread.currentThread().id
                    + ",name is " + Thread.currentThread().name
        )
        itemRecordDao.insertItemRecord(itemRecord)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun deleteTypeRecord(itemRecord: ItemRecord) {
        itemRecordDao.deleteTypeRecord(itemRecord.typeId!!)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getAllRecordByTime(time: String = Utils.timestampToDate(System.currentTimeMillis())): List<ItemRecord> {
        return itemRecordDao.getAllRecordByTime(time)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getPositiveItems():List<ItemRecord> {
        return itemRecordDao.getPositiveItems()
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getNegativeItems():List<ItemRecord> {
        return itemRecordDao.getNegativeItems()
    }
}