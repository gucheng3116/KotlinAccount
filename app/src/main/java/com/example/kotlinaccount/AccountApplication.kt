package com.example.kotlinaccount

import android.app.Application
import androidx.work.PeriodicWorkRequest
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.kotlinaccount.database.AccountDatabase
import com.example.kotlinaccount.database.ItemRecordRepository
import com.example.kotlinaccount.database.ItemTypeRepository
import com.example.kotlinaccount.database.taskDaily.DailyWork
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

    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init() {
        val dailyRequest = PeriodicWorkRequestBuilder<DailyWork>(1,TimeUnit.DAYS).build()
        WorkManager.getInstance(this).enqueue(dailyRequest)

    }
}