package com.example.kotlinaccount.activity

import android.graphics.Color
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinaccount.AccountApplication
import com.example.kotlinaccount.R
import com.example.kotlinaccount.vm.TrendViewModel
import com.example.kotlinaccount.vm.TrendViewModelFactory
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import com.github.mikephil.charting.utils.MPPointF
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.*

class TrendActivity : AppCompatActivity() {
    private val colors = ArrayList<Int>()
    private val viewModel: TrendViewModel by viewModels {
        TrendViewModelFactory(
            (application as AccountApplication).itemRepository,
            (application as AccountApplication).dailyReportRepository
        )
    }

    private lateinit var positiveChart: PieChart
    private lateinit var negativeChart: PieChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trend)
        initColors()
        initPieChart()
        setPositiveData()
        setNegativeData()
    }

    private fun initPieChart() {
        positiveChart = findViewById(R.id.positive_chart)
        positiveChart.setUsePercentValues(true)
        positiveChart.getDescription().isEnabled = false

        negativeChart = findViewById(R.id.negetive_chart)
        negativeChart.setUsePercentValues(true)
        negativeChart.getDescription().isEnabled = false
    }

    private fun setPositiveData() {
        val scope = CoroutineScope(Job())
        scope.launch {
            var items = viewModel.getPositiveItems()
            val entries = ArrayList<PieEntry>()
            var sum = 0.0
            for (item in items) {
                sum += item.amount ?: 0.0
            }
            for (item in items) {
                var value: Float = (item.amount ?: 0.0 / sum).toFloat()
                entries.add(
                    PieEntry(
                        value,
                        item.typeName,
                        null
                    )
                )
            }
            setData(positiveChart,entries,"资产分布")

        }
    }

    private fun setNegativeData() {
        val scope = CoroutineScope(Job())
        scope.launch {
            var items = viewModel.getNegativeItems()
            val entries = ArrayList<PieEntry>()
            var sum = 0.0
            for (item in items) {
                sum += item.amount ?: 0.0
            }
            for (item in items) {
                var value: Float = (item.amount ?: 0.0 / sum).toFloat()
                entries.add(
                    PieEntry(
                        value,
                        item.typeName,
                        null
                    )
                )
            }
            setData(negativeChart,entries,"负债分布")

        }
    }

    private fun initColors() {

        for (c in ColorTemplate.VORDIPLOM_COLORS) colors.add(c)

        for (c in ColorTemplate.JOYFUL_COLORS) colors.add(c)

        for (c in ColorTemplate.COLORFUL_COLORS) colors.add(c)

        for (c in ColorTemplate.LIBERTY_COLORS) colors.add(c)

        for (c in ColorTemplate.PASTEL_COLORS) colors.add(c)


    }

    private fun setData(chart: PieChart, entries: List<PieEntry>,label:String) {
        val dataSet = PieDataSet(entries, label)
        dataSet.setDrawIcons(false)
        dataSet.sliceSpace = 3f
        dataSet.iconsOffset = MPPointF(0F, 40F)
        dataSet.selectionShift = 5f

        dataSet.colors = colors
        var data = PieData(dataSet)
        data.setValueFormatter(PercentFormatter())
        data.setValueTextSize(11f)
        data.setValueTextColor(Color.WHITE)

        chart.setData(data)

        // undo all highlights
        chart.highlightValues(null)

        chart.invalidate()
    }


}