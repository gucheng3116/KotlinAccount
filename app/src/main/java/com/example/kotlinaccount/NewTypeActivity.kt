package com.example.kotlinaccount

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import com.example.kotlinaccount.database.ItemType
import com.example.kotlinaccount.database.RecordViewModel
import com.example.kotlinaccount.database.RecordViewModelFactory

class NewTypeActivity : AppCompatActivity() {

    private lateinit var saveBtn : Button
    private lateinit var nameEdt : EditText

    private val viewModel : RecordViewModel by viewModels {
        RecordViewModelFactory(
            (application as AccountApplication).itemRepository,
            (application as AccountApplication).typeRepository
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