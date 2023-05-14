package com.gucheng.statistichelper

import android.content.Context
import android.content.SharedPreferences
import android.text.TextUtils
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

fun Double.formatAmount(): String {
    return String.format("%.2f", this)
}
// change following class to object
object Utils {

        private val APP_PREF_NAME = "statistic_helper"

        val APP_CHANNEL = ""
        const val UMEN_KEY = "610e49de3451547e683fecae"

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

        fun formatAmount(amount: Double): String {
            val decimalFormat = DecimalFormat("0.00")
            return decimalFormat.format(amount)
        }

        fun dp2px(context:Context, dp : Float) : Int {
            val scale = context.resources.displayMetrics.density
            return (dp*scale + 0.5f).toInt()
        }

}