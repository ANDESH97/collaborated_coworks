package com.brownie.collaborated_cowork.fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brownie.collaborated_cowork.R;

public class CommunityFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = "Community Fragment";

    private View view;

    public CommunityFragment()
    {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.community_fragment, container, false);

        return view;
    }

    @Override
    public void onClick(View v) {

    }
}
