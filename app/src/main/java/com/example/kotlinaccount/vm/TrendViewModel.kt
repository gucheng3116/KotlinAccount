package com.example.kotlinaccount.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinaccount.database.DailyReportRepository
import com.example.kotlinaccount.database.ItemRecordRepository

/**
 * Created on 2021/7/19.
 */
class TrendViewModel(
    private val recordRepository: ItemRecordRepository,
    private val dailyReportRepository: DailyReportRepository
) : ViewModel() {
}

class TrendViewModelFactory(
    private val recordRepository: ItemRecordRepository,
    private val dailyReportRepository: DailyReportRepository
):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TrendViewModel::class.java)) {
            return TrendViewModel(recordRepository,dailyReportRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}

