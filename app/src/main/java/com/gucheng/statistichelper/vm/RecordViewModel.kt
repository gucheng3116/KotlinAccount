package com.gucheng.statistichelper.database

import android.util.Log
import androidx.lifecycle.*
import com.gucheng.statistichelper.Utils
import com.gucheng.statistichelper.database.entity.DailyReport
import com.gucheng.statistichelper.database.entity.ItemRecord
import com.gucheng.statistichelper.database.entity.ItemType
import com.gucheng.statistichelper.database.repository.DailyReportRepository
import com.gucheng.statistichelper.database.repository.ItemRecordRepository
import com.gucheng.statistichelper.database.repository.ItemTypeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject
import kotlin.coroutines.suspendCoroutine

class RecordViewModel(
    private val recordRepository: ItemRecordRepository,
    private val typeRepository: ItemTypeRepository,
    private val dailyReportRepository: DailyReportRepository
) : ViewModel() {
    val allRecords: LiveData<List<ItemRecord>> = recordRepository.allRecords.asLiveData()
    val allTypes: LiveData<List<ItemType>> = typeRepository.allTypes.asLiveData()
    lateinit var selectType: ItemType

    fun insertRecord(itemRecord: ItemRecord) = viewModelScope.launch {

        recordRepository.insert(itemRecord)
    }

    fun deleteTypeRecord(itemRecord: ItemRecord) = viewModelScope.launch {
        if (itemRecord.typeId != null) {
            recordRepository.deleteTypeRecord(itemRecord.typeId!!)
        }

    }

    fun insertType(itemType: ItemType) = viewModelScope.launch {
        typeRepository.insert(itemType)
    }

    suspend fun getAll():List<DailyReport> {

        return suspendCoroutine { continuation ->
            var result:ArrayList<DailyReport> = ArrayList<DailyReport>()
            viewModelScope.launch(Dispatchers.IO) {
                result.addAll(dailyReportRepository.queryLast10())
                var records:List<ItemRecord> = recordRepository.getAllRecordByTime()
                val dailyRecord = DailyReport()
                if (records.isNotEmpty()) {
                    var sum = 0.0
                    var jsonObject = JSONObject()
                    for (itemRecord in records) {
                        sum += itemRecord.amount?:0.0
                        jsonObject.put(itemRecord.typeName,itemRecord.amount)

                    }
                    dailyRecord.createTime = Utils.timestampToDate(System.currentTimeMillis())
                    dailyRecord.date = Utils.timestampToDate(System.currentTimeMillis())
                    dailyRecord.items = jsonObject.toString()
                    dailyRecord.total = sum
                    result.add(dailyRecord)
                }

                Log.d("gucheng","result is " + result.size)
                continuation.resumeWith(Result.success(result))
            }
        }
    }

}

class RecordViewModelFactory(
    private val recordRepository: ItemRecordRepository,
    private val typeRepository: ItemTypeRepository,
    private val dailyReportRepository: DailyReportRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecordViewModel::class.java)) {
            return RecordViewModel(recordRepository, typeRepository, dailyReportRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}