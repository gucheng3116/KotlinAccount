package com.example.kotlinaccount.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinaccount.AccountApplication
import com.example.kotlinaccount.R
import com.example.kotlinaccount.database.RecordViewModel
import com.example.kotlinaccount.database.RecordViewModelFactory
import com.example.kotlinaccount.database.entity.DailyReport
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.*

class KLineActivity : AppCompatActivity() {
    private lateinit var chart: LineChart
    private lateinit var legend: Legend

    private val viewModel: RecordViewModel by viewModels {
        RecordViewModelFactory(
            (application as AccountApplication).itemRepository,
            (application as AccountApplication).typeRepository,
            (application as AccountApplication).dailyReportRepository
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kline)
        chart = findViewById(R.id.chart1)
        initCharts()

    }

    fun initCharts() {
        Log.d(
            "gucheng",
            "initCharts thread id is " + Thread.currentThread().id
                    + ",name is " + Thread.currentThread().name
        )
        chart = findViewById(R.id.chart1)
        chart.description.isEnabled = false
        chart.setTouchEnabled(true)

        // enable scaling and dragging
        chart.isDragEnabled = true
        chart.isScaleXEnabled = true
        chart.isScaleYEnabled = false
        legend = chart.legend
        legend.form = Legend.LegendForm.LINE
        legend.verticalAlignment = Legend.LegendVerticalAlignment.BOTTOM
        legend.horizontalAlignment = Legend.LegendHorizontalAlignment.LEFT

        var values: ArrayList<Entry> = ArrayList<Entry>()
        val scope = CoroutineScope(Job())
        var reports: List<DailyReport>
        scope.launch {
            reports = viewModel.getAll()
            Log.d("gucheng", "reports size is " + reports.size)
            if (reports != null && reports.isNotEmpty()) {
                var count: Float = 0f;
                for (item in reports) {

                    values.add(
                        Entry(
                            count++,
                            item.total?.toFloat() ?: 0f,
                            getResources().getDrawable(R.drawable.star)
                        )
                    )
                }
            }
            var set1: LineDataSet
            var xAxis: XAxis

            xAxis = chart.xAxis
            xAxis.enableGridDashedLine(10f, 10f, 0f)
            xAxis.setLabelCount(Math.min(reports.size, 5), false)

            object : ValueFormatter() {
                override fun getFormattedValue(value: Float): String {
                    Log.d("gucheng", "reports size is " + reports.size + ",value is " + value)
                    if (value < 0) {
                        return ""
                    }
                    if (value.toInt() > reports.size - 1) {
                        return ""
                    }
                    return reports.get(value.toInt()).date?.substring(5, 10) ?: ""
                }
            }.also { xAxis.valueFormatter = it }


            if (chart.data != null &&
                chart.data.dataSetCount > 0
            ) {
                set1 = chart.data.getDataSetByIndex(0) as LineDataSet
                set1.values = values
                set1.notifyDataSetChanged()
                chart.data.notifyDataChanged()
                chart.notifyDataSetChanged()
            } else {
                set1 = LineDataSet(values, "总资产")
                set1.setDrawIcons(false)
            }


            val dataSets = ArrayList<ILineDataSet>()
            dataSets.add(set1) // add the data sets

            val data = LineData(dataSets)

            chart.data = data
            chart.notifyDataSetChanged()
        }


    }
}