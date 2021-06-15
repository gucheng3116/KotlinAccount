package com.example.kotlinaccount.database

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class ItemTypeRepository(private val itemTypeDao: ItemTypeDao) {
    val allTypes: Flow<List<ItemType>> = itemTypeDao.getAllItem()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(itemType: ItemType) {
        itemTypeDao.insertItemType(itemType)
    }
}