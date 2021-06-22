package com.example.kotlinaccount.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "daily_report")
data class DailyReport(
    @PrimaryKey(autoGenerate = true) var id: Int?,
    var items: String?,
    var total: Int = 0,
    var date:Date
)