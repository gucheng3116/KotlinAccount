package com.example.kotlinaccount

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricPrompt
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinaccount.database.RecordViewModel
import com.example.kotlinaccount.database.RecordViewModelFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.concurrent.Executor

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity";
    val handler = Handler();

    private val viewModel: RecordViewModel by viewModels {
        RecordViewModelFactory(
            (application as AccountApplication).itemRepository,
            (application as AccountApplication).typeRepository
        )
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener {
            val intent = Intent(this@MainActivity, NewItemActivity::class.java)
            startActivity(intent)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = RecordAdapter()
        recyclerView.adapter = adapter

        viewModel.allRecords.observe(owner = this) { records ->
            records.let { adapter.submitList(it) }
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
}