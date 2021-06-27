package com.example.kotlinaccount.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.example.kotlinaccount.database.entity.DailyReport


@Dao
interface DailyReportDao {

    @Insert
    suspend fun insert(dailyReport: DailyReport)

    @Update
    suspend fun update(dailyReport: DailyReport)

    @Delete
    suspend fun delete(dailyReport: DailyReport)
}