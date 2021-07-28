package com.example.kotlinaccount.database

import android.text.TextUtils
import androidx.annotation.WorkerThread
import com.example.kotlinaccount.database.dao.ItemTypeDao
import com.example.kotlinaccount.database.entity.ItemType
import kotlinx.coroutines.flow.Flow

class ItemTypeRepository(private val itemTypeDao: ItemTypeDao) {
    val allTypes: Flow<List<ItemType>> = itemTypeDao.getAllItem()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(itemType: ItemType) {
        if (TextUtils.isEmpty(itemType.typeName)) {
            return
        }
        itemTypeDao.insertItemType(itemType)
    }
}