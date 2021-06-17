package com.example.kotlinaccount.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "property_count")
data class PropertyCount(
    @PrimaryKey(autoGenerate = true) var id: Int?,
    var alipay: Float,
    var wechat: Float,
    var total: Float
)