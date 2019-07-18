package com.example.grocer21

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [FoodListContainer.OnFoodListContainerClickListener] interface
 * to handle interaction events.
 */
class FoodListContainer : Fragment() {

    private var mListener: OnFoodListContainerClickListener? = null


    /**
     * Lifecycle method
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_food_list_container, container, false)

        val fab = view.findViewById<FloatingActionButton>(R.id.fab_add_food)
        fab.setOnClickListener { v -> v.setOnClickListener(mListener) }
        return view
    }

    /**
     * Lifecycle method
     */
    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    /**
     * onClickListener for FAB clicks in the [FoodListContainer]
     */
    interface OnFoodListContainerClickListener : View.OnClickListener {

        /**
         * Overridden in the [MainActivity], launches the [AddNewFood] fragment
         */
        override fun onClick(v: View)
    }
}// Required empty public constructor
