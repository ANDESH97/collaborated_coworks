package com.brownie.collaborated_cowork.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.brownie.collaborated_cowork.R;
import com.brownie.collaborated_cowork.fragments.AddOnServicesFragment;
import com.brownie.collaborated_cowork.fragments.BookingFragment;
import com.brownie.collaborated_cowork.fragments.BookmarksFragment;
import com.brownie.collaborated_cowork.fragments.CalendarFragment;
import com.brownie.collaborated_cowork.fragments.CommunityFragment;
import com.brownie.collaborated_cowork.fragments.HomeFragment;
import com.brownie.collaborated_cowork.fragments.LoginFragment;
import com.brownie.collaborated_cowork.fragments.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;

    // Fragment //
    private FragmentManager fragmentManager;
    private Fragment searchFragment, homeFragment, bookmarksFragment, calendarFragment, active, bookingFragment, loginFragment, profileFragment, communityFragment, addOnServicesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init();

        fragmentManager.beginTransaction().replace(R.id.fragment_container, homeFragment).addToBackStack(null).commit();

/*        fragmentManager.beginTransaction().add(R.id.fragment_container, calendarFragment, "welcome_img_2").hide(calendarFragment).commit();
        fragmentManager.beginTransaction().add(R.id.fragment_container, bookingFragment, "welcome_img_3").hide(bookingFragment).commit();
        fragmentManager.beginTransaction().add(R.id.fragment_container, loginFragment, "welcome_img_4").hide(loginFragment).commit();

        fragmentManager.beginTransaction().add(R.id.fragment_container, homeFragment, "welcome_img_1").commit();*/
    }

    private void init()
    {
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        fragmentManager = getSupportFragmentManager();

        communityFragment = new CommunityFragment();
        searchFragment = new SearchFragment();
        homeFragment = new HomeFragment();
        bookmarksFragment = new BookmarksFragment();
        calendarFragment = new CalendarFragment();
        bookingFragment = new BookingFragment();
        loginFragment = new LoginFragment();
        addOnServicesFragment = new AddOnServicesFragment();
        active = homeFragment;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch (id)
        {
            /*case R.id.community:
            {
                fragmentManager.beginTransaction().replace(R.id.fragment_container, communityFragment).disallowAddToBackStack().commit();
                *//*fragmentManager.beginTransaction().hide(active).show(bookingFragment).commit();
                active = bookingFragment;*//*
                return true;
            }*/

            case R.id.home:
            {
                fragmentManager.beginTransaction().replace(R.id.fragment_container, homeFragment).disallowAddToBackStack().commit();
                /*fragmentManager.beginTransaction().hide(active).show(homeFragment).commit();
                active = homeFragment;*/
                return true;
            }

            case R.id.profile:
            {
                fragmentManager.beginTransaction().replace(R.id.fragment_container, loginFragment).disallowAddToBackStack().commit();
                /*
                fragmentManager.beginTransaction().hide(active).show(loginFragment).commit();
                active = loginFragment;*/
                return true;
            }

            case R.id.bookings:
            {
                fragmentManager.beginTransaction().replace(R.id.fragment_container, addOnServicesFragment).disallowAddToBackStack().commit();
                /*fragmentManager.beginTransaction().hide(active).show(calendarFragment).commit();
                active = calendarFragment;*/
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.filter_cafes_menus, menu);

        return true;
    }
}
