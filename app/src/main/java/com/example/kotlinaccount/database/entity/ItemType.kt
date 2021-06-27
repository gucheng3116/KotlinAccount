package com.example.kotlinaccount.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.kotlinaccount.Utils

@Entity(tableName = "item_type")
data class ItemType(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val typeName: String?,
    val createTime: String? = Utils.timestampToDate(System.currentTimeMillis())
)