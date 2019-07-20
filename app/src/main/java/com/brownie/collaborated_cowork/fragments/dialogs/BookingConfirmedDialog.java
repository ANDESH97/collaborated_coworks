package com.brownie.collaborated_cowork.fragments.dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.brownie.collaborated_cowork.R;

public class BookingConfirmedDialog extends DialogFragment {

    private View view;

    public BookingConfirmedDialog()
    {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.dialog_booking_confirmed, container, false);

        return view;
    }
}
