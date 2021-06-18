package com.example.kotlinaccount.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item_type")
data class ItemType(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val typeName: String?,
    val createTime: Long? = System.currentTimeMillis()
)