package com.example.kotlinaccount.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ItemRecord::class, ItemType::class], version = 1)
abstract class AccountDataBase : RoomDatabase() {
}