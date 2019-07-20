package com.brownie.collaborated_cowork.fragments.bottomsheet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.brownie.collaborated_cowork.R;
import com.brownie.collaborated_cowork.adapters.MenuRecyclerViewAdapter;
import com.brownie.collaborated_cowork.adapters.RecyclerViewAdapter;
import com.brownie.collaborated_cowork.adapters.ReviewRecyclerViewAdapter;
import com.brownie.collaborated_cowork.fragments.dialogs.BookingDetailsDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class BottomSheetFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = "BottomSheet Fragment";

    //vars
    private ArrayList<String> mReviewNames = new ArrayList<>();
    private ArrayList<String> mReviewImageUrls = new ArrayList<>();

    private ArrayList<String> mDishNames = new ArrayList<>();
    private ArrayList<String> mDishImageUrls = new ArrayList<>();

    private MenuRecyclerViewAdapter menuAdapter;
    private ReviewRecyclerViewAdapter reviewAdapter;

    private RecyclerView menuRecyclerView, reviewRecyclerView;

    private LinearLayout mapLinearLayout;

    private View view;

    private FloatingActionButton fab;

    public BottomSheetFragment()
    {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.bottom_sheet_fragment, container, false);

        getImages(view);

        fab = view.findViewById(R.id.fab_booking);
        mapLinearLayout = view.findViewById(R.id.bottom_ll2);

        fab.setOnClickListener(this);
        mapLinearLayout.setOnClickListener(this);

        return view;
    }

    private void getImages(View view){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mDishImageUrls.add("https://wset.com/resources/media/2b8a785a-6dfd-4040-8e55-e2513828bd25-large16x9_RedsTavernDoubleBurger.jpg?1527629035706");
        mDishNames.add("Burger");

        mDishImageUrls.add("https://wset.com/resources/media/2b8a785a-6dfd-4040-8e55-e2513828bd25-large16x9_RedsTavernDoubleBurger.jpg?1527629035706");
        mDishNames.add("Burger");

        mDishImageUrls.add("https://wset.com/resources/media/2b8a785a-6dfd-4040-8e55-e2513828bd25-large16x9_RedsTavernDoubleBurger.jpg?1527629035706");
        mDishNames.add("Burger");

        mDishImageUrls.add("https://wset.com/resources/media/2b8a785a-6dfd-4040-8e55-e2513828bd25-large16x9_RedsTavernDoubleBurger.jpg?1527629035706");
        mDishNames.add("Burger");

        mDishImageUrls.add("https://wset.com/resources/media/2b8a785a-6dfd-4040-8e55-e2513828bd25-large16x9_RedsTavernDoubleBurger.jpg?1527629035706");
        mDishNames.add("Burger");

        mReviewImageUrls.add("https://cdn-images-welcome_img_1.medium.com/max/1200/welcome_img_1*gielIwQvaNn0bpBPvzT8YA.jpeg");
        mReviewNames.add("Donald Trump");

        mReviewImageUrls.add("https://cdn-images-welcome_img_1.medium.com/max/1200/welcome_img_1*gielIwQvaNn0bpBPvzT8YA.jpeg");
        mReviewNames.add("Donald Trump");

        mReviewImageUrls.add("https://cdn-images-welcome_img_1.medium.com/max/1200/welcome_img_1*gielIwQvaNn0bpBPvzT8YA.jpeg");
        mReviewNames.add("Donald Trump");

        mReviewImageUrls.add("https://cdn-images-welcome_img_1.medium.com/max/1200/welcome_img_1*gielIwQvaNn0bpBPvzT8YA.jpeg");
        mReviewNames.add("Donald Trump");

        mReviewImageUrls.add("https://cdn-images-welcome_img_1.medium.com/max/1200/welcome_img_1*gielIwQvaNn0bpBPvzT8YA.jpeg");
        mReviewNames.add("Donald Trump");

        initRecyclerView(view);

    }

    private void initRecyclerView(View view){
        Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);

        menuRecyclerView = view.findViewById(R.id.menu_recycler_view);
        reviewRecyclerView = view.findViewById(R.id.review_recycler_view);

        reviewAdapter = new ReviewRecyclerViewAdapter(getContext(), mReviewNames, mReviewImageUrls);
        menuAdapter = new MenuRecyclerViewAdapter(getContext(), mDishNames, mDishImageUrls);

        menuRecyclerView.setAdapter(menuAdapter);
        reviewRecyclerView.setAdapter(reviewAdapter);

//        recyclerView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getFragmentManager().beginTransaction().add(R.id.fragment_container, new CafeDetailFragment()).addToBackStack(null).commit();
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.fab_booking:
            {
                    showDialog();
//                showDiag();
            }
            break;

            case R.id.bottom_ll2:
            {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + 12.9382518 + "," + 77.6247292);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getActivity().getPackageManager()) != null)
                {
                    startActivity(mapIntent);
                }
            }
            break;
        }
    }

    private void showDialog()
    {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("dialog_booking_details");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        DialogFragment dialogFragment = new BookingDetailsDialog();
        dialogFragment.show(ft, "dialog_booking_details");
    }



/*    private void showDiag() {

        final View dialogView = View.inflate(getContext(),R.layout.dialog_booking_details,null);

        final Dialog dialog = new Dialog(getContext(),R.style.MyAlertDialogStyle);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(dialogView);

        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                revealShow(dialogView, true, dialog);
            }
        });

        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i == KeyEvent.KEYCODE_BACK){

                    revealShow(dialogView, false, dialog);
                    return true;
                }

                return false;
            }
        });



        //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        dialog.show();
    }*/

    /*private void revealShow(View dialogView, boolean b, final Dialog dialog) {

        final View view = dialogView.findViewById(R.id.dialog_box_booking);

        int w = view.getWidth();
        int h = view.getHeight();

        int endRadius = (int) Math.hypot(w, h);

        int cx = (int) (fab.getX() + (fab.getWidth()/welcome_img_2));
        int cy = (int) (fab.getY())+ fab.getHeight() + 56;


        if(b){
            Animator revealAnimator = ViewAnimationUtils.createCircularReveal(view, cx,cy, 0, endRadius);

            view.setVisibility(View.VISIBLE);
            revealAnimator.setDuration(700);
            revealAnimator.start();

        } else {

            Animator anim =
                    ViewAnimationUtils.createCircularReveal(view, cx, cy, endRadius, 0);

            anim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    dialog.dismiss();
                    view.setVisibility(View.INVISIBLE);

                }
            });
            anim.setDuration(700);
            anim.start();
        }

    }*/
}
