package com.example.kotlinaccount

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinaccount.database.entity.ItemType
import com.example.kotlinaccount.database.RecordViewModel

class ItemFragment(viewModel: RecordViewModel) : DialogFragment() {
    private var viewModel: RecordViewModel
    private lateinit var listener: TypeSelectListener

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    init {
        this.viewModel = viewModel
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as TypeSelectListener
    }


    interface TypeSelectListener {
        fun typeSelect(itemType: ItemType)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.item_fragment, container, false)
        var recyclerView = view.findViewById<RecyclerView>(R.id.item_recyclerview)
        var typeAdapter = TypeAdapter(listener)
        recyclerView.adapter = typeAdapter
        recyclerView.layoutManager = LinearLayoutManager(container?.context)
        viewModel.allTypes.observe(owner = this) { types ->
            types.let { typeAdapter.submitList(it) }
        }
        return view
    }


}