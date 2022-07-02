package com.gucheng.statistichelper.activity

import java.text.DecimalFormat

/**
 * Created on 2022/7/2.
 */
internal object Utils {
    fun formatAmount(amount: Double): String {
        val decimalFormat = DecimalFormat("0.00")
        return decimalFormat.format(amount)
    }
}