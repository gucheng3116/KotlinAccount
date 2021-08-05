package com.gucheng.statistichelper.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.observe
import androidx.recyclerview.widget.RecyclerView
import com.gucheng.statistichelper.R
import com.gucheng.statistichelper.adapter.EditTypeAdapter
import com.gucheng.statistichelper.database.AccountDatabase
import com.gucheng.statistichelper.database.entity.ItemType
import kotlinx.coroutines.GlobalScope

class EditTypeActivity : AppCompatActivity() {
    private lateinit var mAdapter : EditTypeAdapter
    private lateinit var mList: List<ItemType>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_type)
        val recyclerView = findViewById<RecyclerView>(R.id.type_recyclerview)
        val itemTypeDao = AccountDatabase.getDatabase(this,GlobalScope).itemTypeDao()
        val items: LiveData<List<ItemType>> = itemTypeDao.getAllItem().asLiveData()
        items.observe(owner = this){types->
            mAdapter = EditTypeAdapter(types)
            recyclerView.adapter = mAdapter
        }

    }

}