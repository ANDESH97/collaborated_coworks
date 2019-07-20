package com.brownie.collaborated_cowork.fragments.filter;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import com.brownie.collaborated_cowork.R;

public class FilterFragment extends PreferenceFragmentCompat {


    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.preference_filter);
    }
}
