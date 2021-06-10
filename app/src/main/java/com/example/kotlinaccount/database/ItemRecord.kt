package com.example.kotlinaccount.database

import androidx.room.Entity


@Entity(tableName = "item_record")
data class ItemRecord(
    val id: Integer,
    val type: Integer,
    val amount: Double,
    val typeName: String
)