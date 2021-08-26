package com.gucheng.statistichelper.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import com.gucheng.statistichelper.AccountApplication
import com.gucheng.statistichelper.ItemFragment
import com.gucheng.statistichelper.R
import com.gucheng.statistichelper.database.entity.ItemRecord
import com.gucheng.statistichelper.database.entity.ItemType
import com.gucheng.statistichelper.database.RecordViewModel
import com.gucheng.statistichelper.database.RecordViewModelFactory

class NewItemActivity : AppCompatActivity(), ItemFragment.TypeSelectListener {
    private val viewModel: RecordViewModel by viewModels {
        RecordViewModelFactory(
            (application as AccountApplication).itemRepository,
            (application as AccountApplication).typeRepository,
            (application as AccountApplication).dailyReportRepository
        )
    }

    private lateinit var fragment: ItemFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_item)
        setTitle(R.string.new_property)
        amountEdt = findViewById(R.id.amount)
        typeEdt = findViewById(R.id.type)
        val saveBtn = findViewById<Button>(R.id.button_save)
        saveBtn.setOnClickListener {
            val itemRecord = ItemRecord()
            itemRecord.amount = amountEdt.text.toString().toDouble()
            itemRecord.typeName = viewModel.selectType.typeName
            itemRecord.typeId = viewModel.selectType.id
            val intent = Intent()
            intent.putExtra(EXTRA_NEW_ITEM, itemRecord)
            setResult(RESULT_OK, intent)
            finish()
        }
        fragment = ItemFragment(viewModel)
        typeEdt.setOnClickListener {
            fragment.show(supportFragmentManager, "select")
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
        viewModel.selectType = itemType
        fragment.dismiss()
    }

    fun editType(v: View) {
        val intent = Intent(this, EditTypeActivity::class.java)
        startActivity(intent)

    }

    override fun onDestroy() {
        super.onDestroy()

    }
}