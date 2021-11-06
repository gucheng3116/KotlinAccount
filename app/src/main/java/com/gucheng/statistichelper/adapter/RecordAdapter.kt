package com.gucheng.statistichelper.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gucheng.statistichelper.R
import com.gucheng.statistichelper.activity.KLineActivity
import com.gucheng.statistichelper.activity.ShareActivity
import com.gucheng.statistichelper.adapter.RecordAdapter.RecordViewHolder.Companion.amount
import com.gucheng.statistichelper.database.entity.ItemRecord
import java.text.DecimalFormat

class RecordAdapter(itemListener: ItemListener, list: List<ItemRecord>?) :
    RecyclerView.Adapter<RecordAdapter.BaseViewHolder> (
    ) {
    init {
        listener = itemListener
        datas = list
    }

    abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(position: Int)
    }

    class RecordViewHolder(itemView: View) : BaseViewHolder(itemView) {
        private val itemName: TextView = itemView.findViewById(R.id.item_name)
        private val itemType: TextView = itemView.findViewById(R.id.item_amount)
        private val editBtn: Button = itemView.findViewById(R.id.edit)
        private val itemLayout: View = itemView.findViewById(R.id.item_layout)

        override fun bind(position: Int) {
            var itemRecord: ItemRecord = datas?.get(position)!!
            itemName.text = itemRecord.typeName
            val format = DecimalFormat("0.00")
            itemType.text = format.format(itemRecord.amount)
            editBtn.setOnClickListener {
                listener?.edit(itemRecord)
            }
            itemLayout.setOnLongClickListener {
                listener?.edit(itemRecord)
                true
            }
        }

        companion object {
            var amount:Double = 0.0
            fun create(parent: ViewGroup, viewType: Int): RecordViewHolder {
                if (viewType == VIEW_TYPE.TYPE_FOOTER.ordinal) {
                    return RecordViewHolder(footerView!!)
                }
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.record_item, parent, false)
                return RecordViewHolder(view)
            }
        }

    }

    class FooterViewHolder(itemView: View) : BaseViewHolder(itemView) {
        override fun bind(position: Int) {
            val totalAmounnt: TextView = itemView.findViewById(R.id.total_amount)
            totalAmounnt.setText(amount.toString())
            val changeTrend: TextView = itemView.findViewById(R.id.change_trend)
            changeTrend.setOnClickListener { v ->
                var intent = Intent(v.context, KLineActivity::class.java)
                v.context.startActivity(intent)
             }
            val propertyShare: TextView = itemView.findViewById(R.id.property_share)
            propertyShare.setOnClickListener { v ->
                var intent = Intent(v.context, ShareActivity::class.java)
                v.context.startActivity(intent)
            }
        }
        companion object {
            fun create(parent: ViewGroup) : FooterViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.record_footer,parent,false)
                return FooterViewHolder(view)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        if (viewType == VIEW_TYPE.TYPE_ITEM.ordinal) {
            return RecordViewHolder.create(parent, viewType)
        } else {
            return FooterViewHolder.create(parent)
        }

    }

    fun setFooterView(tail: View) {
        footerView = tail
    }

    interface ItemListener {
        fun delete(record: ItemRecord)

        fun edit(record: ItemRecord)
    }

    companion object {
        var footerView: View? = null
        var listener: ItemListener? = null
        var datas: List<ItemRecord>? = null
        private val RECORD_COMPARATOR = object : DiffUtil.ItemCallback<ItemRecord>() {
            override fun areItemsTheSame(oldItem: ItemRecord, newItem: ItemRecord): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: ItemRecord, newItem: ItemRecord): Boolean {
                return oldItem == newItem
            }

        }
    }

    private enum class VIEW_TYPE {
        TYPE_ITEM,
        TYPE_FOOTER
    }

    override fun getItemCount(): Int {
        var count: Int = datas?.size ?: 0
        if (footerView == null) {
            return count
        } else {
            return count + 1
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (footerView != null && position == (itemCount - 1)) {
            return VIEW_TYPE.TYPE_FOOTER.ordinal
        }
        return VIEW_TYPE.TYPE_ITEM.ordinal
    }

    fun unRegisterListener() {
        listener = null
    }

    fun setTotalAmount(num:Double) {
        amount = num
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(position)

    }

}