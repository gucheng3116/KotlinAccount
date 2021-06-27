package com.example.kotlinaccount

import java.text.SimpleDateFormat
import java.util.*

class Utils {
    companion object{
        fun timestampToDate(milli: Long): String {
            var format:SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            return format.format( Date(milli))
        }
    }

}