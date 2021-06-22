package com.example.kotlinaccount.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update


@Dao
interface DailyReportDao {

    @Insert
    suspend fun insert(dailyReport: DailyReport)

    @Update
    suspend fun update(dailyReport: DailyReport)

    @Delete
    suspend fun delete(dailyReport: DailyReport)
}