package com.example.kotlinaccount

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.kotlinaccount.database.ItemRecord

class NewItemActivity : AppCompatActivity() {


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
    }


    companion object {
        val EXTRA_NEW_ITEM = "new_item"
        lateinit var amountEdt: EditText
        lateinit var typeEdt: EditText
        lateinit var amount: String
        var type: Int = 0
        lateinit var typeName: String

    }
}