package com.gucheng.statistichelper

import android.app.Application
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.gucheng.statistichelper.database.AccountDatabase
import com.gucheng.statistichelper.database.repository.DailyReportRepository
import com.gucheng.statistichelper.database.repository.ItemRecordRepository
import com.gucheng.statistichelper.database.repository.ItemTypeRepository
import com.gucheng.statistichelper.database.taskDaily.DailyWork
import com.tencent.bugly.crashreport.CrashReport
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import java.util.concurrent.TimeUnit

class AccountApplication : Application() {
    companion object {
        val applicationScope = CoroutineScope(SupervisorJob())
    }
    val database by lazy { AccountDatabase.getDatabase(this, applicationScope) }
    val itemRepository by lazy { ItemRecordRepository(database.itemRecordDao()) }
    val typeRepository by lazy { ItemTypeRepository(database.itemTypeDao()) }
    val dailyReportRepository by lazy { DailyReportRepository(database.dailyReportDao()) }

    override fun onCreate() {
        super.onCreate()
        CrashReport.initCrashReport(getApplicationContext(), "0d3fd3563c", true);
        init()
    }

    private fun init() {
        val dailyRequest = PeriodicWorkRequestBuilder<DailyWork>(1,TimeUnit.DAYS).build()
//        WorkManager.getInstance(this).enqueue(dailyRequest)
        WorkManager.getInstance(this).enqueueUniquePeriodicWork("dailywork",
            ExistingPeriodicWorkPolicy.KEEP,dailyRequest)

    }
}