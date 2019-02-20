package com.example.grocer21;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.grocer21.AllergyFragment.OnListFragmentInteractionListener;
import com.example.grocer21.Database.Allergy;

import java.util.List;
import java.util.Objects;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Allergy} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 */
public class MyAllergyRecyclerViewAdapter extends RecyclerView.Adapter<MyAllergyRecyclerViewAdapter.ViewHolder> {

    private final LiveData<List<Allergy>> allergyList;
    private final OnListFragmentInteractionListener mListener;

    public MyAllergyRecyclerViewAdapter(LiveData<List<Allergy>> items, OnListFragmentInteractionListener listener) {
        allergyList = items;
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_allergy, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.mItem = Objects.requireNonNull(allergyList.getValue()).get(position);
        holder.mIdView.setText(allergyList.getValue().get(position).getName());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return Objects.requireNonNull(allergyList.getValue()).size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final TextView mIdView;
        Allergy mItem;

        ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = view.findViewById(R.id.item_number);
        }

        @NonNull
        @Override
        public String toString() {
            return super.toString() + " '" + "'";
        }
    }
}
