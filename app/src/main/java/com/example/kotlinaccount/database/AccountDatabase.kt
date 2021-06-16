package com.example.kotlinaccount.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [ItemRecord::class, ItemType::class], version = 2, exportSchema = false)
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
            var itemRecord = ItemRecord(
                null,
                1,
                16.0,
                "餐饮"
            )
            itemRecordDao.insertItemRecord(itemRecord)
            itemRecord = ItemRecord(
                null,
                2,
                20.0,
                "交通"
            )
            itemRecordDao.insertItemRecord(itemRecord)

            var itemType = ItemType(typeName = "支付宝",type = 1)
            itemTypeDao.insertItemType(itemType)
            itemType = ItemType(typeName = "微信",type = 2)
            itemTypeDao.insertItemType(itemType)

        }

    }
}