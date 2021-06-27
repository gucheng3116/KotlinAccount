package com.example.kotlinaccount.database.taskDaily

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.kotlinaccount.AccountApplication
import com.example.kotlinaccount.Utils
import com.example.kotlinaccount.database.AccountDatabase
import com.example.kotlinaccount.database.entity.DailyReport
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.json.JSONObject
import java.util.*

class DailyWork(appContext: Context, workerParameters: WorkerParameters) :Worker(appContext, workerParameters)  {

    init {
        mContext = appContext
    }

    companion object {
        private lateinit var mContext:Context
    }
    override fun doWork(): Result {
        val calendar: Calendar = Calendar.getInstance()
        calendar.add(Calendar.DATE, -1)
        val itemRecordDao = AccountDatabase.getDatabase(
            mContext,
            AccountApplication.applicationScope
        ).itemRecordDao()
        val dailyReportDao = AccountDatabase.getDatabase(
            mContext,
           AccountApplication.applicationScope
        ).dailyReportDao()

        var records = itemRecordDao.getAllRecordByTime(getEndOfLastDay())
        var sum = 0.0;
        var jsonObject = JSONObject()
        for (item in records) {
            jsonObject.put(item.typeName,item.amount)
            sum += item.amount?:0.0;
        }
        var report = DailyReport()
        report.items = jsonObject.toString()
        report.date = Utils.timestampToDate(getEndOfLastDay())
        report.total = sum
        AccountApplication.applicationScope.launch{ dailyReportDao.insert(report) }

        return Result.success()
    }

    fun getEndOfLastDay(): Long {
        val calendar: Calendar = Calendar.getInstance()
        calendar.add(Calendar.DATE, -1)
        calendar.set(Calendar.HOUR_OF_DAY, 23)
        calendar.set(Calendar.MINUTE,59)
        calendar.set(Calendar.SECOND,59)
        return calendar.timeInMillis
    }
}