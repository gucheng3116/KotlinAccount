package com.gucheng.statistichelper.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gucheng.statistichelper.R
import com.gucheng.statistichelper.database.entity.ItemRecord
import java.lang.ref.WeakReference
import java.text.DecimalFormat

class RecordAdapter(val itemListener: ItemListener) : ListAdapter<ItemRecord, RecordAdapter.RecordViewHolder>(
    RECORD_COMPARATOR
) {
    init {
        listener = itemListener
    }
    class RecordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemName: TextView = itemView.findViewById(R.id.item_name)
        private val itemType: TextView = itemView.findViewById(R.id.item_amount)
        private val editBtn: Button = itemView.findViewById(R.id.edit)
        private val itemLayout:View = itemView.findViewById(R.id.item_layout)

        fun bind(itemRecord: ItemRecord) {
            itemName.text = itemRecord.typeName
            val format = DecimalFormat("0.00")
            itemType.text = format.format(itemRecord.amount)
            editBtn.setOnClickListener {
                listener?.edit(itemRecord)
            }
            itemLayout.setOnLongClickListener{
                listener?.edit(itemRecord)
                true
            }
        }

        companion object {
            fun create(parent: ViewGroup): RecordViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.record_item, parent, false)
                return RecordViewHolder(view)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordViewHolder {
        return RecordViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RecordViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    interface ItemListener {
        fun delete(record: ItemRecord)

        fun edit(record:ItemRecord)
    }

    companion object {
        var listener : ItemListener? = null
        private val RECORD_COMPARATOR = object : DiffUtil.ItemCallback<ItemRecord>() {
            override fun areItemsTheSame(oldItem: ItemRecord, newItem: ItemRecord): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: ItemRecord, newItem: ItemRecord): Boolean {
                return oldItem == newItem
            }

        }
    }

    fun unRegisterListener() {
        listener = null
    }
}