package com.example.kotlinaccount.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinaccount.AccountApplication
import com.example.kotlinaccount.R
import com.example.kotlinaccount.vm.TrendViewModel
import com.example.kotlinaccount.vm.TrendViewModelFactory
import com.github.mikephil.charting.charts.PieChart

class TrendActivity : AppCompatActivity() {

    private val viewModel:TrendViewModel by viewModels {
        TrendViewModelFactory(
            (application as AccountApplication).itemRepository,
            (application as AccountApplication).dailyReportRepository
        )
    }

    private lateinit var pieChart: PieChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trend)
    }

    private fun initPieChart() {
        pieChart = findViewById(R.id.pie_chart)
        pieChart.setUsePercentValues(true)
        pieChart.getDescription().isEnabled = false
    }
}