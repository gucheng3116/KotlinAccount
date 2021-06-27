package com.example.kotlinaccount.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kotlinaccount.database.entity.ItemType
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemTypeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItemType(itemType: ItemType)

    @Query("select * from item_type")
    fun getAllItem(): Flow<List<ItemType>>
}