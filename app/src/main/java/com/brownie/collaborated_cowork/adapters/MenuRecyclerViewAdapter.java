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

public class MenuRecyclerViewAdapter extends RecyclerView.Adapter<MenuRecyclerViewAdapter.MenuViewHolder> implements View.OnClickListener {

    private static final String TAG = "MenuRecyclerViewAdapter";

    // vars //
    private ArrayList<String> menuNames = new ArrayList<>();
    private ArrayList<String> menuImageUrls = new ArrayList<>();
    private Context mContext;

    public MenuRecyclerViewAdapter(Context mContext, ArrayList<String> menuNames, ArrayList<String> menuImageUrls) {
        this.menuNames = menuNames;
        this.menuImageUrls = menuImageUrls;
        this.mContext = mContext;
    }

    @Override
    public void onClick(View v) {

    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: called.");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_recycler_card, parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {

        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(mContext)
                .asBitmap()
                .load(menuImageUrls.get(position))
                .into(holder.dishImage);

        holder.dishName.setText(menuNames.get(position));

    }

    @Override
    public int getItemCount() {
        return menuNames.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder
    {
        ImageView dishImage;
        TextView dishName;


        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);

            dishImage = itemView.findViewById(R.id.card_dish_image);
            dishName = itemView.findViewById(R.id.card_dish_name);

        }
    }
}
