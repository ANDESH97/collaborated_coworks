package com.brownie.collaborated_cowork.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.brownie.collaborated_cowork.R;

public class BookmarksFragment extends Fragment {

    private static final String TAG = "Bookmarks Fragment";

    private View view;

    public BookmarksFragment()
    {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.bookmarks_fragment, container, false);

        return view;
    }
}
