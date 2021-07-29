package com.example.kotlinaccount.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.kotlinaccount.Utils
import com.example.kotlinaccount.database.DailyReportRepository
import com.example.kotlinaccount.database.ItemRecordRepository
import com.example.kotlinaccount.database.entity.DailyReport
import com.example.kotlinaccount.database.entity.ItemRecord
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.lang.IllegalArgumentException
import kotlin.coroutines.suspendCoroutine

/**
 * Created on 2021/7/21.
 */
class KLineViewModel(
    private val recordRepository: ItemRecordRepository,
    private val dailyReportRepository: DailyReportRepository
) : ViewModel() {
    suspend fun queryDailyReport(): List<DailyReport> {

        return suspendCoroutine { continuation ->
            var result: ArrayList<DailyReport> = ArrayList<DailyReport>()
            viewModelScope.launch(Dispatchers.IO) {
                result.addAll(dailyReportRepository.queryLast10())
                var records: List<ItemRecord> = recordRepository.getAllRecordByTime()
                val dailyRecord = DailyReport()
                if (records.isNotEmpty()) {
                    var sum = 0.0
                    var jsonObject = JSONObject()
                    for (itemRecord in records) {
                        sum += itemRecord.amount ?: 0.0
                        jsonObject.put(itemRecord.typeName, itemRecord.amount)

                    }
                    dailyRecord.createTime = Utils.timestampToDate(System.currentTimeMillis())
                    dailyRecord.date = Utils.timestampToDate(System.currentTimeMillis())
                    dailyRecord.items = jsonObject.toString()
                    dailyRecord.total = sum
                    result.add(dailyRecord)
                }

                Log.d("gucheng", "result is " + result.size)
                continuation.resumeWith(Result.success(result))
            }
        }
    }

    suspend fun queryWeeklyReport(): List<DailyReport> {

        return suspendCoroutine { continuation ->
            var result: ArrayList<DailyReport> = ArrayList<DailyReport>()
            viewModelScope.launch(Dispatchers.IO) {
                result.addAll(dailyReportRepository.queryWeeklyReport())
                if (result.size > 0) {
                    result.removeAt(result.size - 1)
                }
                var records: List<ItemRecord> = recordRepository.getAllRecordByTime()
                val dailyRecord = DailyReport()
                if (records.isNotEmpty()) {
                    var sum = 0.0
                    var jsonObject = JSONObject()
                    for (itemRecord in records) {
                        sum += itemRecord.amount ?: 0.0
                        jsonObject.put(itemRecord.typeName, itemRecord.amount)

                    }
                    dailyRecord.createTime = Utils.timestampToDate(System.currentTimeMillis())
                    dailyRecord.date = Utils.timestampToDate(System.currentTimeMillis())
                    dailyRecord.items = jsonObject.toString()
                    dailyRecord.total = sum
                    result.add(dailyRecord)
                }

                Log.d("gucheng", "result is " + result.size)
                continuation.resumeWith(Result.success(result))
            }
        }
    }

    suspend fun queryMonthlyReport(): List<DailyReport> {

        return suspendCoroutine { continuation ->
            var result: ArrayList<DailyReport> = ArrayList<DailyReport>()
            viewModelScope.launch(Dispatchers.IO) {
                result.addAll(dailyReportRepository.queryMonthlyReport())
                if (result.size > 0) {
                    result.removeAt(result.size - 1)
                }
                var records: List<ItemRecord> = recordRepository.getAllRecordByTime()
                val dailyRecord = DailyReport()
                if (records.isNotEmpty()) {
                    var sum = 0.0
                    var jsonObject = JSONObject()
                    for (itemRecord in records) {
                        sum += itemRecord.amount ?: 0.0
                        jsonObject.put(itemRecord.typeName, itemRecord.amount)

                    }
                    dailyRecord.createTime = Utils.timestampToDate(System.currentTimeMillis())
                    dailyRecord.date = Utils.timestampToDate(System.currentTimeMillis())
                    dailyRecord.items = jsonObject.toString()
                    dailyRecord.total = sum
                    result.add(dailyRecord)
                }

                Log.d("gucheng", "result is " + result.size)
                continuation.resumeWith(Result.success(result))
            }
        }
    }
}

class KLineViewModelFactory(
    private val recordRepository: ItemRecordRepository,
    private val dailyReportRepository: DailyReportRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(KLineViewModel::class.java)) {
            return KLineViewModel(recordRepository, dailyReportRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

