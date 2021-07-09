package com.example.kotlinaccount.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.kotlinaccount.database.dao.DailyReportDao
import com.example.kotlinaccount.database.dao.ItemRecordDao
import com.example.kotlinaccount.database.dao.ItemTypeDao
import com.example.kotlinaccount.database.entity.DailyReport
import com.example.kotlinaccount.database.entity.ItemRecord
import com.example.kotlinaccount.database.entity.ItemType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [ItemRecord::class, ItemType::class, DailyReport::class], version = 4, exportSchema = false)
abstract class AccountDatabase : RoomDatabase() {

    abstract fun itemRecordDao(): ItemRecordDao
    abstract fun itemTypeDao(): ItemTypeDao
    abstract fun dailyReportDao() : DailyReportDao

    companion object {
        @Volatile
        private var INSTANCE: AccountDatabase? = null

        val MIGARATION_3_4 = object :Migration(3,4) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE daily_report ADD COLUMN createTime TEXT")
            }

        }

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): AccountDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AccountDatabase::class.java,
                    "account_database"
                ).addCallback(AccountDatabaseCallback(scope))
                    .addMigrations(MIGARATION_3_4).build()
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