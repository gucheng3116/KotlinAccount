package com.example.kotlinaccount.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kotlinaccount.database.entity.ItemRecord
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemRecordDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItemRecord(record: ItemRecord)

    @Query("select * from item_record where id in (select max(id) from item_record group by typeId) and isDel = 0")
    fun getAllRecord(): Flow<List<ItemRecord>>

    @Query("select * from item_record where id in (select max(id) from item_record group by typeId) and isDel = 0 and strftime('%s',createTime) <= :time")
    fun getAllRecordByTime(time: Long = System.currentTimeMillis()): List<ItemRecord>

    @Query("update item_record set isDel=1 where typeId = :typeId")
    suspend fun deleteTypeRecord(typeId: Int)
}
