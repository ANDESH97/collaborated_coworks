package com.brownie.collaborated_cowork.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.brownie.collaborated_cowork.R;
import com.brownie.collaborated_cowork.adapters.RecyclerViewAdapter;
import com.brownie.collaborated_cowork.adapters.TabAdapter;
import com.brownie.collaborated_cowork.fragments.bottomsheet.BottomSheetFragment;
import com.brownie.collaborated_cowork.models.C2C;
import com.brownie.collaborated_cowork.retrofit.ApiClient;
import com.brownie.collaborated_cowork.retrofit.ApiInterface;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment implements RecyclerViewAdapter.CafesAdapterListener {

    private static final String TAG = "Home Fragment";

/*    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;*/

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    private ApiInterface apiInterface;
    private List<C2C> c2cList;

    private RecyclerViewAdapter adapter;
    private RecyclerView recyclerView;

    private View view;

    public HomeFragment()
    {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.home_fragment, container, false);

/*        viewPager = view.findViewById(R.id.viewPager);
        tabLayout = view.findViewById(R.id.tabLayout);

        adapter = new TabAdapter(getFragmentManager(), TabAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        adapter.addFragment(new NearbyRecyclerFragment(), "Nearby");
        adapter.addFragment(new PopularRecyclerFragment(), "Popular");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);*/

        SearchView svCafes = view.findViewById(R.id.svCafes);

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

        c2cList = new ArrayList<>();

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<C2C>> call = apiInterface.getAllC2Cs();

        call.enqueue(new Callback<List<C2C>>() {
            @Override
            public void onResponse(Call<List<C2C>> call, Response<List<C2C>> response) {
                if(response.isSuccessful())
                {
                    Log.d(TAG, "onResponse: " + response.body());
                    c2cList = response.body();
                    getImages(view);
                }
                else
                {
                    Log.d(TAG, "onResponse: failed!");
                }

            }

            @Override
            public void onFailure(Call<List<C2C>> call, Throwable t) {
                t.printStackTrace();
            }
        });



        return view;
    }

    private void getImages(View view){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        /*mImageUrls.add("https://c1.staticflickr.com/welcome_img_5/4636/25316407448_de5fbf183d_o.jpg");
        mNames.add("Havasu Cafe");*/

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

        adapter = new RecyclerViewAdapter(getActivity(),c2cList, this);
        recyclerView.setAdapter(adapter);

        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().add(R.id.fragment_container, new BottomSheetFragment()).addToBackStack(null).commit();
            }
        });
    }


    @Override
    public void onSelected(String item) {
        Toast.makeText(getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

}
