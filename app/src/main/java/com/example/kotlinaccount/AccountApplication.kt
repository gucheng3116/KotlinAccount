package com.example.kotlinaccount

import android.app.Application
import com.example.kotlinaccount.database.AccountDatabase
import com.example.kotlinaccount.database.ItemRecordRepository
import com.example.kotlinaccount.database.ItemTypeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class AccountApplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy { AccountDatabase.getDatabase(this, applicationScope) }
    val itemRepository by lazy { ItemRecordRepository(database.itemRecordDao()) }
    val typeRepository by lazy { ItemTypeRepository(database.itemTypeDao()) }

}