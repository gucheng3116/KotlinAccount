package com.example.kotlinaccount.database.dao

import androidx.room.*
import com.example.kotlinaccount.database.entity.DailyReport


@Dao
interface DailyReportDao {

    @Insert
    suspend fun insert(dailyReport: DailyReport)

    @Update
    suspend fun update(dailyReport: DailyReport)

    @Delete
    suspend fun delete(dailyReport: DailyReport)

    @Query("select * from daily_report")
    fun queryAll(): List<DailyReport>

    @Query("select * from (select * from daily_report order by id desc limit 10) order by date")
    fun queryLast10(): List<DailyReport>

    @Query("select * from daily_report where date=:date")
    suspend fun queryDateReport(date: String): List<DailyReport>
}