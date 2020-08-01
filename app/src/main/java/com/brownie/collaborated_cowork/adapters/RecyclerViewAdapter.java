package com.brownie.collaborated_cowork.adapters;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.brownie.collaborated_cowork.R;
import com.brownie.collaborated_cowork.fragments.CafeDetailFragment;
import com.brownie.collaborated_cowork.fragments.bottomsheet.BottomSheetFragment;
import com.brownie.collaborated_cowork.models.C2C;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.HomeViewHolder> implements /*View.OnClickListener,*/ Filterable {

    private static final String TAG = "RecyclerViewAdapater";

    // vars //
    private ArrayList<String> cafeNames = new ArrayList<>();
    private ArrayList<String> cafeImageUrls = new ArrayList<>();
    private ArrayList<String> itemsFiltered = new ArrayList<>();
    private C2C c2cData;

    private BottomSheetFragment bottomSheetFragment;

    private List<C2C> dataset;
    private Context mContext;

    private CafesAdapterListener listener;

    public RecyclerViewAdapter(Context mContext, List<C2C> c2cDataset, CafesAdapterListener listener)
    {
        this.mContext = mContext;
        this.dataset = c2cDataset;
        this.listener = listener;

        this.bottomSheetFragment = new BottomSheetFragment();
    }
/*    public RecyclerViewAdapter(Context mContext, ArrayList<String> cafeNames, ArrayList<String> cafeImageUrls, CafesAdapterListener listener) {
        this.cafeNames = cafeNames;
        this.cafeImageUrls = cafeImageUrls;
        this.mContext = mContext;

        this.listener = listener;
        this.itemsFiltered = new ArrayList<>(cafeNames);
    }*/

/*    @Override
    public void onClick(View v) {
        AppCompatActivity appCompatActivity = (AppCompatActivity) v.getContext();
        Fragment cafeDetail = new CafeDetailFragment();
        appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, cafeDetail).addToBackStack(null).commit();
    }*/

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: called.");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_card, parent, false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, final int position) {

        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(mContext)
                .asBitmap()
                .load(dataset.get(position).getImageUrl())
                .into(holder.cafeImage);

        holder.cafeName.setText(dataset.get(position).getC2cName());
        holder.row_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                c2cData = dataset.get(position);
                FragmentManager fragmentManager = ((AppCompatActivity)mContext).getSupportFragmentManager();
                Bundle c2cBundle = new Bundle();
                c2cBundle.putSerializable("C2C_DATA", c2cData);
                fragmentManager.beginTransaction().replace(R.id.fragment_container, bottomSheetFragment).addToBackStack(null).commit();
                bottomSheetFragment.setArguments(c2cBundle);

                Log.d(TAG, "onClick: c2cData= " + c2cData);
                Log.d(TAG, "onClick: card row clicked! ");
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String query = charSequence.toString().toLowerCase().trim();

                List<String> filtered = new ArrayList<>();

                if (query.isEmpty()) {
                    filtered.addAll(itemsFiltered);
//                    filtered = cafeNames;
                }
                else {
                    for (String cafe : itemsFiltered) {
                        if (cafe.toLowerCase().contains(query)) {
                            filtered.add(cafe);
                        }
                    }
                }

                FilterResults results = new FilterResults();
                results.count = filtered.size();
                results.values = filtered;
                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults results) {
                Log.d(TAG, "publishResults: results" + itemsFiltered.toString());
                cafeNames.clear();
                cafeNames.addAll((ArrayList<String>) results.values);
                notifyDataSetChanged();
            }
        };
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder
    {
        ConstraintLayout row_layout;
        ImageView cafeImage;
        TextView cafeName;


        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);

            row_layout = itemView.findViewById(R.id.card_row);
            cafeImage = itemView.findViewById(R.id.recycler_card_image);
            cafeName = itemView.findViewById(R.id.recycler_cafe_name);

            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onSelected(itemsFiltered.get(getAdapterPosition()));
                }
            });*/
        }
    }

    public interface CafesAdapterListener {
        void onSelected(String item);
    }
}
