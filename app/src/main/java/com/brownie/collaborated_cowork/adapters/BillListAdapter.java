package com.brownie.collaborated_cowork.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.brownie.collaborated_cowork.R;
import com.brownie.collaborated_cowork.models.BillDetailItem;

import java.util.ArrayList;

public class BillListAdapter extends BaseAdapter {

    private ArrayList<BillDetailItem> billDetails;
    private LayoutInflater layoutInflater;

    public BillListAdapter(Context context, ArrayList<BillDetailItem> billDetails) {
        this.billDetails = billDetails;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return billDetails.size();
    }

    @Override
    public Object getItem(int position) {
        return billDetails.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View v, ViewGroup vg) {
        ViewHolder holder;
        if (v == null) {
            v = layoutInflater.inflate(R.layout.bill_detail_row, null);

            holder = new ViewHolder();
            holder.tvSeatTotal = v.findViewById(R.id.tv_bill_total_amount);
            holder.tvAdditionalCharges = v.findViewById(R.id.additional_cost_amount);

            v.setTag(holder);
        }
        else
            {
            holder = (ViewHolder) v.getTag();
        }

        holder.tvSeatTotal.setText(billDetails.get(position).getSeatTotal());
        holder.tvAdditionalCharges.setText(billDetails.get(position).getAdditionalCharges());

        return v;
    }

    public static class ViewHolder {
        TextView tvSeatTotal;
        TextView tvAdditionalCharges;
    }
}
