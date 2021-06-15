package com.example.kotlinaccount.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "item_record")
data class ItemRecord(
    @PrimaryKey(autoGenerate = true) val id: Integer?,
    val type: Int,
    val amount: Double,
    val typeName: String
)