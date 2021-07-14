package com.example.kotlinaccount.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricPrompt
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinaccount.AccountApplication
import com.example.kotlinaccount.R
import com.example.kotlinaccount.RecordAdapter
import com.example.kotlinaccount.Utils
import com.example.kotlinaccount.database.RecordViewModel
import com.example.kotlinaccount.database.RecordViewModelFactory
import com.example.kotlinaccount.database.entity.DailyReport
import com.example.kotlinaccount.database.entity.ItemRecord
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.*
import java.util.concurrent.Executor

class MainActivity : AppCompatActivity(), RecordAdapter.ItemListener {
    val TAG = "MainActivity";
    val handler = Handler();
    private val REQUEST_CODE_NEW_ITEM = 1
    private lateinit var amountTotal: TextView
    private lateinit var chart: LineChart
    private lateinit var legend: Legend

    private val viewModel: RecordViewModel by viewModels {
        RecordViewModelFactory(
            (application as AccountApplication).itemRepository,
            (application as AccountApplication).typeRepository,
            (application as AccountApplication).dailyReportRepository
        )
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val scope = CoroutineScope(Job())
        initCharts()
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener {
            val intent = Intent(this@MainActivity, NewItemActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_NEW_ITEM)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = RecordAdapter(this)
        recyclerView.adapter = adapter

        amountTotal = findViewById(R.id.total_amount)

        viewModel.allRecords.observe(owner = this) { records ->
            records.let {
                adapter.submitList(it)
                adapter.notifyDataSetChanged()
            }
            var sum: Double = 0.0
            amountTotal.setText(records.let {
                var item: ItemRecord? = null
                for (item in it) {
                    if (item.amount != null) {
                        sum += item.amount!!
                    }
                }
                sum.toString()
            })
        }
    }

    private val executor = Executor { command -> handler.post(command) }

    @RequiresApi(Build.VERSION_CODES.N)
    fun showDialog() {
        val promptInfo: BiometricPrompt.PromptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("指纹登录") //设置大标题
            .setNegativeButtonText("取消") //设置取消按钮
            .build()


        //需要提供的参数callback
        val biometricPrompt = BiometricPrompt(this@MainActivity,
            executor, object : BiometricPrompt.AuthenticationCallback() {
                //各种异常的回调
                override fun onAuthenticationError(
                    errorCode: Int,
                    errString: CharSequence
                ) {
                    super.onAuthenticationError(errorCode, errString)
                    Toast.makeText(
                        applicationContext,
                        "Authentication error: $errString", Toast.LENGTH_SHORT
                    )
                        .show()
                }

                //认证成功的回调
                override fun onAuthenticationSucceeded(
                    result: BiometricPrompt.AuthenticationResult
                ) {
                    super.onAuthenticationSucceeded(result)
                    Log.d(TAG, "success")
                    Toast.makeText(
                        applicationContext,
                        "Authentication success: ", Toast.LENGTH_SHORT
                    )
                        .show()
                    // User has verified the signature, cipher, or message
                    // authentication code (MAC) associated with the crypto object,
                    // so you can use it in your app's crypto-driven workflows.
                }

                //认证失败的回调
                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                    Toast.makeText(
                        applicationContext, "Authentication failed",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            })

        // 显示认证对话框
        biometricPrompt.authenticate(promptInfo)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (REQUEST_CODE_NEW_ITEM == requestCode && RESULT_OK == resultCode) {
            var itemRecord = data?.getParcelableExtra<ItemRecord>(NewItemActivity.EXTRA_NEW_ITEM)
            if (itemRecord != null) {
                viewModel.insertRecord(itemRecord)
            }
        }
    }

    override fun delete(record: ItemRecord) {

        var builder = AlertDialog.Builder(this)
        builder.setMessage(R.string.confirm_delete)
            .setPositiveButton(R.string.confirm, { dialog, id ->
                viewModel.deleteTypeRecord(record)
            }).setNegativeButton(R.string.cancel, null)
        var dialog = builder.create()
        dialog.show()
    }

    override fun edit(record: ItemRecord) {
        val view = LayoutInflater.from(this).inflate(R.layout.record_edit_item, null)
        var amountEdt = view.findViewById<EditText>(R.id.amount)
        amountEdt.setText(record.amount.toString())
        var typeText = view.findViewById<TextView>(R.id.type)
        typeText.setText(record.typeName)
        var builder = AlertDialog.Builder(this)
        builder.setView(view).setTitle(R.string.edit_record)
            .setNegativeButton(R.string.cancel, null)
            .setPositiveButton(R.string.confirm, { id, dialog ->
                record.amount = amountEdt.text.toString().toDouble()
                record.createTime = Utils.timestampToDate(System.currentTimeMillis())
                viewModel.insertRecord(record)
                Log.d(
                    "gucheng",
                    "edit thread id is " + Thread.currentThread().id
                            + ",name is " + Thread.currentThread().name
                )
            })
        var dialog = builder.create()
        dialog.show()

    }

     fun initCharts() {
        Log.d(
            "gucheng",
            "initCharts thread id is " + Thread.currentThread().id
                    + ",name is " + Thread.currentThread().name
        )
        chart = findViewById(R.id.chart1)
        legend = chart.legend
        legend.form = Legend.LegendForm.LINE
        legend.verticalAlignment = Legend.LegendVerticalAlignment.BOTTOM
        legend.horizontalAlignment = Legend.LegendHorizontalAlignment.LEFT

        var values:ArrayList<Entry> = ArrayList<Entry>()
         val scope = CoroutineScope(Job())
         var reports:List<DailyReport>
         scope.launch {
             reports = viewModel.getAll()
             Log.d("gucheng","reports size is " + reports.size)
             if (reports != null && reports.isNotEmpty()) {
                 var count: Float = 0f;
                 for (item in reports) {

                     values.add(
                         Entry(
                             count++,
                             item.total?.toFloat()?:0f,
                             getResources().getDrawable(R.drawable.star)
                         )
                     )
                 }
             }
             var set1: LineDataSet
             var xAxis : XAxis

             xAxis = chart.xAxis
             xAxis.enableGridDashedLine(10f,10f,0f)

             object : ValueFormatter() {
                 override fun getFormattedValue(value: Float): String {
                     return reports.get(value.toInt()).date?:""
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
                 set1 = LineDataSet(values, "DataSet 1")
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