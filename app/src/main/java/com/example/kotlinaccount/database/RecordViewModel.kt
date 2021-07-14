package com.example.kotlinaccount.database

import android.util.Log
import androidx.lifecycle.*
import com.example.kotlinaccount.database.entity.DailyReport
import com.example.kotlinaccount.database.entity.ItemRecord
import com.example.kotlinaccount.database.entity.ItemType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class RecordViewModel(
    private val recordRepository: ItemRecordRepository,
    private val typeRepository: ItemTypeRepository,
    private val dailyReportRepository: DailyReportRepository
) : ViewModel() {
    val allRecords: LiveData<List<ItemRecord>> = recordRepository.allRecords.asLiveData()
    val allTypes: LiveData<List<ItemType>> = typeRepository.allTypes.asLiveData()

    fun insertRecord(itemRecord: ItemRecord) = viewModelScope.launch {

        recordRepository.insert(itemRecord)
    }

    fun deleteTypeRecord(itemRecord: ItemRecord) = viewModelScope.launch {
        recordRepository.deleteTypeRecord(itemRecord)
    }

    fun insertType(itemType: ItemType) = viewModelScope.launch {
        typeRepository.insert(itemType)
    }


    fun getDailyReport() : List<DailyReport> {
        var result:List<DailyReport> = ArrayList<DailyReport>()
        viewModelScope.launch(Dispatchers.IO) {
            result = dailyReportRepository.queryAll()
        }
        return result
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