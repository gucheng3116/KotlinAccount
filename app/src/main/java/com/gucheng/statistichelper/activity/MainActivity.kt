package com.gucheng.statistichelper.activity

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
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
import com.gucheng.statistichelper.AccountApplication
import com.gucheng.statistichelper.R
import com.gucheng.statistichelper.adapter.RecordAdapter
import com.gucheng.statistichelper.Utils
import com.gucheng.statistichelper.database.RecordViewModel
import com.gucheng.statistichelper.database.RecordViewModelFactory
import com.gucheng.statistichelper.database.entity.ItemRecord
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*
import java.util.concurrent.Executor

class MainActivity : AppCompatActivity(), RecordAdapter.ItemListener {
    val TAG = "MainActivity";
    val handler = Handler();
    private val REQUEST_CODE_NEW_ITEM = 1
    private lateinit var amountTotal: TextView
    private lateinit var changeTrend: TextView
    private val KEY_AGREE_USER_PROTOCOL = "agree_user_protocol"

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
        setTitle(getString(R.string.property_statistc))
        if (!isAgreeUserProtocol()) {
            showUserProtocol()
        }
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener {
            val intent = Intent(this@MainActivity, NewItemActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_NEW_ITEM)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = RecordAdapter(this)
        recyclerView.adapter = adapter

        changeTrend = findViewById(R.id.change_trend)
        changeTrend.setOnClickListener({v ->
            val intent = Intent(this@MainActivity, KLineActivity::class.java)
            startActivity(intent)
        })

        val shareTxt = findViewById<TextView>(R.id.property_share)
        shareTxt.setOnClickListener { v ->
            val intent = Intent(this@MainActivity, ShareActivity::class.java)
            startActivity(intent)
        }

        amountTotal = findViewById(R.id.total_amount)

        var emptyView = findViewById<View>(R.id.empty_view)
        var recordLayout = findViewById<View>(R.id.record_layout)

        viewModel.allRecords.observe(owner = this) { records ->
            records.let { records ->
                adapter.submitList(records)
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
            if (records == null || records.isEmpty()) {
                emptyView.visibility = View.VISIBLE
                recordLayout.visibility = View.GONE
            } else {
                emptyView.visibility = View.GONE
                recordLayout.visibility = View.VISIBLE
            }
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
            }).setNeutralButton(R.string.delete,{id,dialog ->
                delete(record)
            })
        var dialog = builder.create()
        dialog.show()

    }

    private fun showUserProtocol() {
        var builder = AlertDialog.Builder(this)
//        builder.setMessage(R.string.confirm_delete)
//            .setPositiveButton(R.string.confirm, { dialog, id ->
//                viewModel.deleteTypeRecord(record)
//            }).setNegativeButton(R.string.cancel, null)
        var view = LayoutInflater.from(this).inflate(R.layout.user_protocol,null);
        builder.setView(view).setCancelable(false)
        var dialog = builder.create()
        var userPromptTxt = view.findViewById<TextView>(R.id.user_hint)
        var userHint = getString(R.string.user_hint)
        var privacyString = getString(R.string.privacy_policy)
        var serviceString = getString(R.string.service_protocol)
        var privacyStart = userHint.indexOf(privacyString)
        var privacyEnd = privacyStart + privacyString.length
        var serviceStart = userHint.indexOf(serviceString)
        var serviceEnd = serviceStart + serviceString.length
        var sp = SpannableString(getString(R.string.user_hint))
        userPromptTxt.movementMethod = LinkMovementMethod.getInstance()
        sp.setSpan(object : ClickableSpan() {
            override fun onClick(widget: View) {
                val intent = Intent(this@MainActivity, ProtocolActivity::class.java)
                intent.putExtra(ProtocolActivity.PROTOCOL_TYPE, ProtocolActivity.MODE_PRIVACY)
                startActivity(intent)
            }
        },privacyStart,privacyEnd, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        sp.setSpan(Color.BLUE, privacyStart,privacyEnd,Spanned.SPAN_INCLUSIVE_EXCLUSIVE)

        sp.setSpan(object : ClickableSpan() {
            override fun onClick(widget: View) {
                val intent = Intent(this@MainActivity, ProtocolActivity::class.java)
                intent.putExtra(ProtocolActivity.PROTOCOL_TYPE, ProtocolActivity.MODE_PROTOCOL)
                startActivity(intent)
            }
        },serviceStart,serviceEnd, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        sp.setSpan(Color.BLUE, serviceStart,serviceEnd,Spanned.SPAN_INCLUSIVE_EXCLUSIVE)


        userPromptTxt.setText(sp)
        val agreeBtn = view.findViewById<Button>(R.id.agree)
        agreeBtn.setOnClickListener{
            var editor = Utils.getAppPref(this).edit()
            editor.putBoolean(KEY_AGREE_USER_PROTOCOL, true)
            editor.apply()
            dialog.dismiss()
        }
        val cancelBtn = view.findViewById<Button>(R.id.cancel)
        cancelBtn.setOnClickListener {
            dialog.dismiss()
            finish()
        }
        dialog.show()
    }

    private fun isAgreeUserProtocol():Boolean{
        var prefs:SharedPreferences = Utils.getAppPref(this)
        return prefs.getBoolean(KEY_AGREE_USER_PROTOCOL, false)
    }


}