package com.example.kotlinaccount.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import com.example.kotlinaccount.AccountApplication
import com.example.kotlinaccount.ItemFragment
import com.example.kotlinaccount.R
import com.example.kotlinaccount.database.entity.ItemRecord
import com.example.kotlinaccount.database.entity.ItemType
import com.example.kotlinaccount.database.RecordViewModel
import com.example.kotlinaccount.database.RecordViewModelFactory

class NewItemActivity : AppCompatActivity(), ItemFragment.TypeSelectListener {
    private val viewModel: RecordViewModel by viewModels {
        RecordViewModelFactory(
            (application as AccountApplication).itemRepository,
            (application as AccountApplication).typeRepository
        )
    }
    private lateinit var selectType: ItemType

    private lateinit var fragment: ItemFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_item)
        amountEdt = findViewById(R.id.amount)
        typeEdt = findViewById(R.id.type)
        val saveBtn = findViewById<Button>(R.id.button_save)
        saveBtn.setOnClickListener {
            val itemRecord = ItemRecord()
            itemRecord.amount = amountEdt.text.toString().toDouble()
            itemRecord.typeName = selectType.typeName
            itemRecord.typeId = selectType.id
            val intent = Intent()
            intent.putExtra(EXTRA_NEW_ITEM, itemRecord)
            setResult(RESULT_OK, intent)
            finish()
        }
        fragment = ItemFragment(viewModel)
        typeEdt.setOnClickListener {
            fragment.show(supportFragmentManager, "test")
        }

        val newBtn = findViewById<Button>(R.id.new_type)
        newBtn.setOnClickListener {
            var intent: Intent = Intent(this, NewTypeActivity::class.java)
            startActivity(intent)
        }
    }


    companion object {
        val EXTRA_NEW_ITEM = "new_item"
        lateinit var amountEdt: EditText
        lateinit var typeEdt: EditText
        var type: Int = 0

    }

    override fun typeSelect(itemType: ItemType) {
        typeEdt.setText(itemType.typeName)
        selectType = itemType
        fragment.dismiss()
    }

    fun editType(v: View) {
        val intent = Intent(this, EditTypeActivity::class.java)
        startActivity(intent)

    }
}