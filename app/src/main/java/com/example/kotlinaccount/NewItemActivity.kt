package com.example.kotlinaccount

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import com.example.kotlinaccount.database.ItemRecord
import com.example.kotlinaccount.database.ItemType
import com.example.kotlinaccount.database.RecordViewModel
import com.example.kotlinaccount.database.RecordViewModelFactory

class NewItemActivity : AppCompatActivity(),ItemFragment.TypeSelectListener {

    private val viewModel: RecordViewModel by viewModels {
        RecordViewModelFactory(
            (application as AccountApplication).itemRepository,
            (application as AccountApplication).typeRepository
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_item)
        amountEdt = findViewById(R.id.amount)
        typeEdt = findViewById(R.id.type)
        val saveBtn = findViewById<Button>(R.id.button_save)
        saveBtn.setOnClickListener {
            val itemRecord = ItemRecord()
            val intent = Intent()
            intent.putExtra(EXTRA_NEW_ITEM,itemRecord)
            setResult(RESULT_OK,intent)
            finish()
        }
        typeEdt.setOnClickListener {
            var fragment = ItemFragment(viewModel)
            fragment.show(supportFragmentManager, "test")
        }
    }


    companion object {
        val EXTRA_NEW_ITEM = "new_item"
        lateinit var amountEdt: EditText
        lateinit var typeEdt: EditText
        lateinit var amount: String
        var type: Int = 0
        lateinit var typeName: String

    }

    override fun typeSelect(itemType: ItemType) {
        typeEdt.setText(itemType.typeName)
    }
}