package com.brownie.collaborated_cowork.fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.brownie.collaborated_cowork.R;
import com.google.android.material.button.MaterialButton;

public class AddOnServicesFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = "AddOnServicesFragment";

    private View view;

    private Button addZypherService, addCigaretteService, addLaundryService;

    private FragmentManager fragmentManager;

    private Fragment cartFragment;

    public AddOnServicesFragment()
    {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.cc_services, container, false);

        init(view);

        return view;
    }

    private void init(View view)
    {
        fragmentManager = getFragmentManager();
        cartFragment = new CartFragment();

        addZypherService = view.findViewById(R.id.add_zypher_service);
        addCigaretteService = view.findViewById(R.id.add_cigarette_service);
        addLaundryService = view.findViewById(R.id.add_laundry_service);

        addZypherService.setOnClickListener(this);
        addCigaretteService.setOnClickListener(this);
        addLaundryService.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.add_zypher_service:
            {
                fragmentManager.beginTransaction().replace(R.id.fragment_container, cartFragment).addToBackStack(null).commit();
            }
            break;

            case R.id.add_cigarette_service:
            {
                fragmentManager.beginTransaction().replace(R.id.fragment_container, cartFragment).addToBackStack(null).commit();
            }
            break;

            case R.id.add_laundry_service:
            {
                fragmentManager.beginTransaction().replace(R.id.fragment_container, cartFragment).addToBackStack(null).commit();
            }
        }

    }
}
