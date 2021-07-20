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

    private val viewModel: TrendViewModel by viewModels {
        TrendViewModelFactory(
            (application as AccountApplication).itemRepository,
            (application as AccountApplication).dailyReportRepository
        )
    }

    private lateinit var pieChart: PieChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trend)
        initPieChart()
        setData()
    }

    private fun initPieChart() {
        pieChart = findViewById(R.id.pie_chart)
        pieChart.setUsePercentValues(true)
        pieChart.getDescription().isEnabled = false
    }

    private fun setData() {
        val scope = CoroutineScope(Job())
        scope.launch {
            var items = viewModel.getPositiveItem()
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
            val dataSet = PieDataSet(entries, "Election Results")
            dataSet.setDrawIcons(false)
            dataSet.sliceSpace = 3f
            dataSet.iconsOffset = MPPointF(0F, 40F)
            dataSet.selectionShift = 5f

            // add a lot of colors
            val colors = ArrayList<Int>()
            for (c in ColorTemplate.VORDIPLOM_COLORS) colors.add(c)

            for (c in ColorTemplate.JOYFUL_COLORS) colors.add(c)

            for (c in ColorTemplate.COLORFUL_COLORS) colors.add(c)

            for (c in ColorTemplate.LIBERTY_COLORS) colors.add(c)

            for (c in ColorTemplate.PASTEL_COLORS) colors.add(c)

            dataSet.colors = colors
            var data = PieData(dataSet)
            data.setValueFormatter(PercentFormatter())
            data.setValueTextSize(11f)
            data.setValueTextColor(Color.WHITE)

            pieChart.setData(data)

            // undo all highlights
            pieChart.highlightValues(null)

            pieChart.invalidate()

        }
    }
}