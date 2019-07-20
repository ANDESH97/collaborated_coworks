package com.brownie.collaborated_cowork.adapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.brownie.collaborated_cowork.R;
import com.brownie.collaborated_cowork.models.BillDetailItem;

import java.util.ArrayList;

public class BookingSummaryFragment extends Fragment {

    private static final String TAG = "Summary Fragment";

    private View view;

    public BookingSummaryFragment()
    {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.booking_summary, container, false);

        ArrayList newBillList = getBillData();

        ListView lv = view.findViewById(R.id.billing_list);

        lv.setAdapter(new BillListAdapter(getContext(), newBillList));

        return view;
    }

    private ArrayList getBillData()
    {
        ArrayList<BillDetailItem> billList = new ArrayList<>();

        BillDetailItem bill1 = new BillDetailItem();

        bill1.setSeatTotal(100);
        bill1.setAdditionalCharges(7);

        billList.add(bill1);

        return billList;

    }
}
