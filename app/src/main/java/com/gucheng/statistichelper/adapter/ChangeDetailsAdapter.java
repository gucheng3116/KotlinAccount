package com.gucheng.statistichelper.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gucheng.statistichelper.R;
import com.gucheng.statistichelper.Utils;
import com.gucheng.statistichelper.database.entity.ChangeRecord;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


/**
 * Created on 2021/11/30.
 */
public class ChangeDetailsAdapter extends RecyclerView.Adapter<ChangeDetailsAdapter.ChangeViewHolder> {
    private ArrayList<ChangeRecord> mDatas;

    public ChangeDetailsAdapter(ArrayList<ChangeRecord> datas) {
        mDatas = datas;
    }

    @Override
    public ChangeViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_change_detail,parent,false);
        return new ChangeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ChangeViewHolder holder, int position) {
        ChangeRecord record = mDatas.get(position);
        holder.dateTxt.setText(record.getCreateTime());
        if (record.getChangeAmount() > 0) {
            holder.amountTxt.setText("+" + Utils.INSTANCE.formatAmount(record.getChangeAmount()));
        } else {
            holder.amountTxt.setText(Utils.INSTANCE.formatAmount(record.getChangeAmount()));
        }
        holder.remarkTxt.setText(record.getRemark());
//      holder.itemBalance.setText("余额: " + record.getBalance());

    }



    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    class ChangeViewHolder extends RecyclerView.ViewHolder {
        TextView dateTxt;
        TextView amountTxt;
        TextView remarkTxt;
//        TextView itemBalance;
        public ChangeViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            dateTxt = itemView.findViewById(R.id.date);
            amountTxt = itemView.findViewById(R.id.change_amount);
            remarkTxt = itemView.findViewById(R.id.remark);
//            itemBalance = itemView.findViewById(R.id.balance);

        }
    }
}


