package com.example.kotlinaccount.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.util.*

@Database(entities = [ItemRecord::class, ItemType::class], version = 3, exportSchema = false)
abstract class AccountDatabase : RoomDatabase() {

    abstract fun itemRecordDao(): ItemRecordDao
    abstract fun itemTypeDao(): ItemTypeDao

    companion object {
        @Volatile
        private var INSTANCE: AccountDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): AccountDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AccountDatabase::class.java,
                    "account_database"
                ).addCallback(AccountDatabaseCallback(scope)).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }

        private class AccountDatabaseCallback(private val scope: CoroutineScope) :
            RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                INSTANCE?.let { database ->
                    scope.launch {
                        populateDatabase(database.itemRecordDao(), database.itemTypeDao())
                    }
                }
            }
        }

        suspend fun populateDatabase(itemRecordDao: ItemRecordDao, itemTypeDao: ItemTypeDao) {

            var itemType = ItemType(typeName = "支付宝")
            itemTypeDao.insertItemType(itemType)
            itemType = ItemType(typeName = "微信")
            itemTypeDao.insertItemType(itemType)

        }

    }
}