package com.example.kotlinaccount

import android.text.TextUtils
import java.text.SimpleDateFormat
import java.util.*

class Utils {
    companion object{
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
    }

}