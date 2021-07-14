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
    lateinit var allDailyReport: List<DailyReport>
    init {
        val scope = CoroutineScope(Job())
        scope.launch {
            initDailyReport()
        }
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun queryAll(): List<DailyReport> {
        return dailyReportDao.queryAll()
    }

    @WorkerThread
    suspend fun initDailyReport() {
        Log.d(
            "gucheng",
            "initDailyReport thread id is " + Thread.currentThread().id
                    + ",name is " + Thread.currentThread().name
        )
        allDailyReport = dailyReportDao.queryAll()
    }
}