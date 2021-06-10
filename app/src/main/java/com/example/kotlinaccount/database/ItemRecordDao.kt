package com.example.kotlinaccount.database

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

interface ItemRecordDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItemRecord(record: ItemRecord)

    @Query("select * from item_record")
    fun getAllRecord() : Flow<List<ItemRecord>>
}