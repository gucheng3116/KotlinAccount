package com.gucheng.statistichelper

import android.app.Application
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.gucheng.statistichelper.database.AccountDatabase
import com.gucheng.statistichelper.database.repository.ChangeRecordRepository
import com.gucheng.statistichelper.database.repository.DailyReportRepository
import com.gucheng.statistichelper.database.repository.ItemRecordRepository
import com.gucheng.statistichelper.database.repository.ItemTypeRepository
import com.gucheng.statistichelper.database.taskDaily.DailyWork
import com.umeng.analytics.MobclickAgent
import com.umeng.commonsdk.UMConfigure
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
    val changeRecordRepository by lazy { ChangeRecordRepository(database.changeRecordDao()) }

    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init() {
        val dailyRequest = PeriodicWorkRequestBuilder<DailyWork>(1, TimeUnit.DAYS).build()
        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
            "dailywork",
            ExistingPeriodicWorkPolicy.KEEP, dailyRequest
        )

//        UMConfigure.setLogEnabled(false)
        UMConfigure.preInit(this@AccountApplication, "610e49de3451547e683fecae", "")
        MobclickAgent.setPageCollectionMode(MobclickAgent.PageMode.AUTO)
        MobclickAgent.setSessionContinueMillis(100 * 1000)

    }
}