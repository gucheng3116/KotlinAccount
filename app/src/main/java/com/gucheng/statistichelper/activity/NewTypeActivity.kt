package com.gucheng.statistichelper.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import com.gucheng.statistichelper.AccountApplication
import com.gucheng.statistichelper.R
import com.gucheng.statistichelper.database.entity.ItemType
import com.gucheng.statistichelper.database.RecordViewModel
import com.gucheng.statistichelper.database.RecordViewModelFactory

class NewTypeActivity : AppCompatActivity() {

    private lateinit var saveBtn : Button
    private lateinit var nameEdt : EditText

    private val viewModel : RecordViewModel by viewModels {
        RecordViewModelFactory(
            (application as AccountApplication).itemRepository,
            (application as AccountApplication).typeRepository,
        (application as AccountApplication).dailyReportRepository
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_type)
        saveBtn = findViewById(R.id.button_save)
        nameEdt = findViewById(R.id.type_name)
        saveBtn.setOnClickListener {
            var itemType = ItemType(null,nameEdt.text.toString())
            viewModel.insertType(itemType)
            finish()
        }
    }

}