package com.brownie.collaborated_cowork.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.brownie.collaborated_cowork.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ReviewRecyclerViewAdapter extends RecyclerView.Adapter<ReviewRecyclerViewAdapter.ReviewViewHolder> implements View.OnClickListener {

    private static final String TAG = "Review Recycler Adapter";

    // vars //
    private ArrayList<String> reviewPersonNames = new ArrayList<>();
    private ArrayList<String> reviewPersonImageUrls = new ArrayList<>();
    private Context mContext;

    public ReviewRecyclerViewAdapter(Context mContext, ArrayList<String> reviewPersonNames, ArrayList<String> reviewPersonImageUrls) {
        this.reviewPersonNames = reviewPersonNames;
        this.reviewPersonImageUrls = reviewPersonImageUrls;
        this.mContext = mContext;
    }

    @Override
    public void onClick(View v) {

    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: called.");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_recycler_card, parent, false);
        return new ReviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {

        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(mContext)
                .asBitmap()
                .load(reviewPersonImageUrls.get(position))
                .into(holder.reviewPersonImage);

        holder.reviewPersonName.setText(reviewPersonNames.get(position));

    }

    @Override
    public int getItemCount() {
        return reviewPersonNames.size();
    }

    public class ReviewViewHolder extends RecyclerView.ViewHolder
    {
        ImageView reviewPersonImage;
        TextView reviewPersonName;


        public ReviewViewHolder(@NonNull View itemView) {
            super(itemView);

            reviewPersonImage = itemView.findViewById(R.id.review_profile_image);
            reviewPersonName = itemView.findViewById(R.id.review_profile_name);

        }
    }
}
