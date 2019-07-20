package com.brownie.collaborated_cowork.fragments;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.brownie.collaborated_cowork.R;
import com.brownie.collaborated_cowork.adapters.RecyclerViewAdapter;

import java.util.ArrayList;

public class NearbyRecyclerFragment extends Fragment implements RecyclerViewAdapter.CafesAdapterListener  {

    private static final String TAG = "Nearby Fragment";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    private RecyclerViewAdapter adapter;
    private RecyclerView recyclerView;

    private View view;

    public NearbyRecyclerFragment()
    {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.nearby_recycler_fragment, container, false);

        SearchView svCafes = view.findViewById(R.id.svCafes);

        getImages(view);

        svCafes.setActivated(true);
        svCafes.setQueryHint("Type your keyword here");
        svCafes.onActionViewExpanded();
        svCafes.setIconified(false);
        svCafes.clearFocus();

        svCafes.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d(TAG, "onQueryTextSubmit: submitted");
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d(TAG, "onQueryTextChange: here with new text = " + newText);
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        return view;
    }

    private void getImages(View view){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://c1.staticflickr.com/welcome_img_5/4636/25316407448_de5fbf183d_o.jpg");
        mNames.add("Havasu Falls");

        mImageUrls.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        mNames.add("Trondheim");

        mImageUrls.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        mNames.add("Portugal");

        mImageUrls.add("https://i.redd.it/j6myfqglup501.jpg");
        mNames.add("Rocky Mountain National Park");


        mImageUrls.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        mNames.add("Mahahual");

        mImageUrls.add("https://i.redd.it/k98uzl68eh501.jpg");
        mNames.add("Frozen Lake");


        mImageUrls.add("https://i.redd.it/glin0nwndo501.jpg");
        mNames.add("White Sands Desert");

        mImageUrls.add("https://i.redd.it/obx4zydshg601.jpg");
        mNames.add("Austrailia");

        mImageUrls.add("https://i.imgur.com/ZcLLrkY.jpg");
        mNames.add("Washington");

        initRecyclerView(view);

    }

    private void initRecyclerView(View view){
        Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);

        recyclerView = view.findViewById(R.id.nearby_recycler_view);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerViewAdapter(getContext(), mNames, mImageUrls, this);
        recyclerView.setAdapter(adapter);

        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().add(R.id.fragment_container, new CafeDetailFragment()).addToBackStack(null).commit();
            }
        });
    }


    @Override
    public void onSelected(String item) {
        Toast.makeText(getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
}
