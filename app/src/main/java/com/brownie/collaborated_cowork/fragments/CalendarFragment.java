package com.brownie.collaborated_cowork.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.brownie.collaborated_cowork.R;
import com.brownie.collaborated_cowork.fragments.bottomsheet.BottomSheetFragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class CalendarFragment extends Fragment implements ViewPager.OnPageChangeListener{

    private static final String TAG = "Calendar Fragment";

    private View view;

    private FloatingActionButton fab;

    private ViewPager viewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    private int[] layouts;

    public CalendarFragment()
    {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.dish_details, container, false);

        getFragmentManager().beginTransaction().replace(R.id.bottom_sheet_fragment_container, new BottomSheetFragment()).addToBackStack(null).commit();

        fab = view.findViewById(R.id.fab);
        CoordinatorLayout coordinatorLayout = view.findViewById(R.id.bottom_sheet);
        coordinatorLayout.setBackgroundResource(R.drawable.bg_bottom_sheet);
        /*LinearLayout llBottomSheet = view.findViewById(R.id.bottom_sheet);
        llBottomSheet.setBackgroundResource(R.drawable.bg_bottom_sheet);
*/
        // init the bottom sheet behavior
        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(coordinatorLayout);

        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

                fab.animate().scaleX(1 - slideOffset).scaleY(1 - slideOffset).setDuration(0).start();
            }
        });

        viewPager = view.findViewById(R.id.dish_details_vp);

        TabLayout tabLayout = view.findViewById(R.id.dish_details_tab_layout);
        tabLayout.setupWithViewPager(viewPager, true);

        layouts = new int[]{
                R.layout.random_1,
                R.layout.detail_pager_2,
                R.layout.detail_pager_3};

        myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(this);
        return view;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    /**
     * View pager adapter
     */
    public class MyViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter() {
        }

        @NonNull
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }
}
