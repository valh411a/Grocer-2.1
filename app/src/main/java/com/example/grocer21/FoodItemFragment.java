package com.example.grocer21;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FoodItemFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class FoodItemFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private OnFragmentInteractionListener mListener;
    private String foodName;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        foodName = Objects.requireNonNull(this.getArguments()).getString("name");

        DatabaseViewModel databaseViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(DatabaseViewModel.class);
        if (getArguments() != null) {
            int mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_food_item, container, false);

        TextView viewPiece = view.findViewById(R.id.food_name);
        viewPiece.setText(foodName);


        if(savedInstanceState == null) {
            DietFragment foodItemDietList = new DietFragment();
            AllergyFragment foodItemAllergyList = new AllergyFragment();
            getChildFragmentManager()
                    .beginTransaction()
                    .add(R.id.list_a_container, foodItemDietList)
                    .commit();
            getChildFragmentManager()
                    .beginTransaction()
                    .add(R.id.list_b_container, foodItemAllergyList)
                    .commit();
        }

    return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public FoodItemFragment() {
        // Required empty public constructor
    }

    public static FoodItemFragment newInstance(int columnCount) {
        FoodItemFragment fragment = new FoodItemFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        @SuppressWarnings("EmptyMethod")
        void onFragmentInteraction();
    }
}
