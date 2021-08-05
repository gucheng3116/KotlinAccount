package com.gucheng.statistichelper

import android.content.Context
import android.content.SharedPreferences
import android.text.TextUtils
import java.text.SimpleDateFormat
import java.util.*

class Utils {

    companion object{
        private val APP_PREF_NAME = "statistic_helper"

        val TIME_FORMAT = "yyyy-MM-dd HH:mm:ss"
        fun timestampToDate(milli: Long): String {
            var format:SimpleDateFormat = SimpleDateFormat(TIME_FORMAT)
            return format.format( Date(milli))
        }

        fun dateToTimestamp(date: String?):Long {
            if (TextUtils.isEmpty(date)) {
                return 0;
            }
            var format = SimpleDateFormat(TIME_FORMAT)
            var date2 = format.parse(date)
            return date2.time
        }

        fun getAppPref(context:Context) : SharedPreferences {
            return context.getSharedPreferences(APP_PREF_NAME,Context.MODE_PRIVATE)
        }
    }

}