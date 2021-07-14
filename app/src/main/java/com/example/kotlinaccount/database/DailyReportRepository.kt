package com.example.kotlinaccount.database

import android.util.Log
import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import com.example.kotlinaccount.database.dao.DailyReportDao
import com.example.kotlinaccount.database.entity.DailyReport
import kotlinx.coroutines.*

/**
 * Created on 2021/7/13.
 */
class DailyReportRepository(private val dailyReportDao: DailyReportDao) {


    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun queryAll(): List<DailyReport> {
        Log.d(
            "gucheng",
            "queryAll report thread id is " + Thread.currentThread().id
                    + ",name is " + Thread.currentThread().name
        )
        return dailyReportDao.queryAll()
    }

    suspend fun queryLast10():List<DailyReport> {
        return dailyReportDao.queryLast10()
    }

}