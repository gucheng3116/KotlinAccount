package com.example.kotlinaccount.database.taskDaily

import android.content.Context
import android.os.AsyncTask
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.kotlinaccount.Utils
import com.example.kotlinaccount.database.AccountDatabase
import com.example.kotlinaccount.database.entity.DailyReport
import com.example.kotlinaccount.database.entity.ItemRecord
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId
import java.util.*

class DailyStaticTask(context: Context, scope: CoroutineScope) : AsyncTask<Void?, Void?, Void?>() {

    companion object {
        lateinit var mContext: Context
        lateinit var mScope: CoroutineScope
    }

    init {
        mContext = context
        mScope = scope
    }

    override fun doInBackground(vararg params: Void?): Void? {
        val calendar: Calendar = Calendar.getInstance()
        calendar.add(Calendar.DATE, -1)
        val itemRecordDao = AccountDatabase.getDatabase(mContext, mScope).itemRecordDao()
        val dailyReportDao = AccountDatabase.getDatabase(mContext, mScope).dailyReportDao()

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

        mScope.launch{ dailyReportDao.insert(report) }




        return null
    }

    fun getEndOfLastDay(): Long {
        val calendar: Calendar = Calendar.getInstance()
        calendar.add(Calendar.DATE, -1)
        calendar.set(Calendar.HOUR_OF_DAY, 23)
        calendar.set(Calendar.MINUTE,59)
        calendar.set(Calendar.SECOND,59)
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

        return calendar.timeInMillis
    }
}