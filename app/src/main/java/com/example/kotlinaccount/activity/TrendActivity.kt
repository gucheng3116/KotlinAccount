package com.example.kotlinaccount.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.kotlinaccount.AccountApplication
import com.example.kotlinaccount.R
import com.example.kotlinaccount.vm.TrendViewModel
import com.example.kotlinaccount.vm.TrendViewModelFactory

class TrendActivity : AppCompatActivity() {

    private val viewModel:TrendViewModel by viewModels {
        TrendViewModelFactory(
            (application as AccountApplication).itemRepository,
            (application as AccountApplication).dailyReportRepository
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trend)
    }
}