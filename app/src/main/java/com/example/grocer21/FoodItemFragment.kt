package com.example.grocer21

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [FoodItemFragment.OnFoodItemFragmentInteractionListener] interface
 * to handle interaction events.
 */
class FoodItemFragment : Fragment() {
    private var mListener: OnFoodItemFragmentInteractionListener? = null
    private var foodName: String? = null

    /**
     * LifeCycle Method
     */
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFoodItemFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException("$context must implement AllergyItemFragmentInteractionListener")
        }

    }

    /**
     * LifeCycle Method
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        foodName = (this.arguments)?.getString("name")

        (activity)?.let { ViewModelProviders.of(it).get(DatabaseViewModel::class.java) }
        if (arguments != null) {
            (arguments ?: return).getInt(ARG_COLUMN_COUNT)
        }
    }

    /**
     * LifeCycle Method
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_food_item, container, false)

        val viewPiece = view.findViewById<TextView>(R.id.food_name)
        viewPiece.text = foodName


        if (savedInstanceState == null) {
            val foodItemDietList = DietListFragment()
            val foodItemAllergyList = AllergyListFragment()
            childFragmentManager
                    .beginTransaction()
                    .add(R.id.list_a_container, foodItemDietList)
                    .commit()
            childFragmentManager
                    .beginTransaction()
                    .add(R.id.list_b_container, foodItemAllergyList)
                    .commit()
        }

        return view
    }

    /**
     * LifeCycle Method
     */
    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    /**
     * Listener for interactions on the fragment in the [MainActivity]
     */
    interface OnFoodItemFragmentInteractionListener {
        /**
         * overridden handler for interactions on the fragment in the [MainActivity]
         */
        fun onFoodItemFragmentInteraction()
    }

    companion object {

        private const val ARG_COLUMN_COUNT = "column-count"

    }
}// Required empty public constructor
