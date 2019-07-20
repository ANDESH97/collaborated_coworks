package com.brownie.collaborated_cowork.fragments.dialogs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.brownie.collaborated_cowork.R;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;

public class BookingDetailsDialog extends DialogFragment implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    private static final String TAG = "BookingDetails Dialog";

    private View view;

    private Button increase_button, decrease_button, confirm_button, date_button;

    private TextView displayInteger;

    private DatePickerDialog datePickerDialog;

    private Calendar calendar ;

    int minteger = 0, Year, Month, Day;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.dialog_booking_details, container, false);

        init(view);

        return view;
    }

    private void init(View view)
    {
        displayInteger =  view.findViewById(R.id.tv_number_of_seats);
        increase_button = view.findViewById(R.id.btn_increase);
        decrease_button = view.findViewById(R.id.btn_decrease);
        confirm_button = view.findViewById(R.id.btn_details_confirm);
        date_button = view.findViewById(R.id.dialog_button_date);

        increase_button.setOnClickListener(this);
        decrease_button.setOnClickListener(this);
        confirm_button.setOnClickListener(this);

        calendar = Calendar.getInstance();

        Year = calendar.get(Calendar.YEAR) ;
        Month = calendar.get(Calendar.MONTH);
        Day = calendar.get(Calendar.DAY_OF_MONTH);
    }

    private void increaseInteger()
    {
        minteger = minteger + 1;
        display(minteger);

    }

    private void decreaseInteger() {
        minteger = minteger - 1;
        display(minteger);
    }

    @SuppressLint("SetTextI18n")
    private void display(int number) {

        displayInteger.setText("" + number);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btn_increase :
            {
                increaseInteger();
            }
            break;

            case R.id.btn_decrease :
            {
                decreaseInteger();
            }
            break;

            case R.id.btn_details_confirm :
            {
                showConfirmDialog();
            }
            break;

            case R.id.dialog_button_date :
            {
                showCalendar();
            }
            break;
        }

    }

    private void showConfirmDialog()
    {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("dialog_booking_details");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        DialogFragment dialogFragment = new BookingConfirmedDialog();
        dialogFragment.show(ft, "dialog_booking_confirmed");
    }

    private void showCalendar()
    {
        datePickerDialog = DatePickerDialog.newInstance(this, Year, Month, Day);

        datePickerDialog.setThemeDark(false);

        datePickerDialog.showYearPickerFirst(false);

        datePickerDialog.setAccentColor(Color.parseColor("#0072BA"));

        datePickerDialog.setTitle("Select Date");

        datePickerDialog.show(getFragmentManager(), "DatePickerDialog");
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {

        String date = Day + "/" + Month + "/" + Year;

        date_button.setText(date);
    }
}
