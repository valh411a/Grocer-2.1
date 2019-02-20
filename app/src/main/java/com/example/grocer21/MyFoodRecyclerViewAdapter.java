package com.example.grocer21;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.grocer21.Database.Food;
import com.example.grocer21.FoodFragment.OnListFragmentInteractionListener;

import java.util.List;
import java.util.Objects;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Food} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 */
public class MyFoodRecyclerViewAdapter extends RecyclerView.Adapter<MyFoodRecyclerViewAdapter.ViewHolder> {

    private final LiveData<List<Food>> foodList;
    private final OnListFragmentInteractionListener mListener;

    public MyFoodRecyclerViewAdapter(LiveData<List<Food>> items, OnListFragmentInteractionListener listener) {
        foodList = items;
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_food, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.mItem = Objects.requireNonNull(foodList.getValue()).get(position);
        holder.mIdView.setText(foodList.getValue().get(position).getName());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return Objects.requireNonNull(foodList.getValue()).size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final TextView mIdView;
        Food mItem;

        ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = view.findViewById(R.id.item_number);
        }

        @NonNull
        @Override
        public String toString() {
            return super.toString() + " '"  + "'";
        }
    }
}
