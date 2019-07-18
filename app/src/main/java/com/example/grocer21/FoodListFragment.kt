package com.example.grocer21

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout.VERTICAL
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.grocer21.database.entities.Foods

/**
 * A fragment representing a list of Items.
 *
 *
 * Activities containing this fragment MUST implement the OnAllergyListFragmentInteractionListener
 * interface.
 */
/**
 * Mandatory empty constructor for the fragment manager to instantiate the
 * fragment (e.g. upon screen orientation changes).
 */
class FoodListFragment : Fragment() {
    private var mColumnCount = 1
    private var mListener: OnFoodListFragmentInteractionListener? = null
    private var databaseViewModel: DatabaseViewModel? = null


    /**
     * Lifecycle method
     */
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFoodListFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException("$context must implement OnAllergyListFragmentInteractionListener")
        }
    }

    /**
     * Lifecycle method
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        databaseViewModel = DatabaseViewModel(Application())
        if (arguments != null) {
            mColumnCount = (arguments ?: return).getInt(ARG_COLUMN_COUNT)
        }
    }

    /**
     * Lifecycle method
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_food_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            val context = view.getContext()
            if (mColumnCount <= 1) {
                view.layoutManager = LinearLayoutManager(context)
            } else {
                view.layoutManager = GridLayoutManager(context, mColumnCount)
            }
            view.addItemDecoration(DividerItemDecoration(view.context, VERTICAL))
            view.adapter = this.context?.let { FoodListAdapter(it) }
        }
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
     * Listener for item clicks in the [FoodListFragment]
     */
    interface OnFoodListFragmentInteractionListener {
        /**
         * Overridden in the [MainActivity], creates a [FoodItemFragment] from the list
         * item selected
         */
        fun onFoodListFragmentInteraction(item: Foods)
    }

    companion object {

        private const val ARG_COLUMN_COUNT = "column-count"

    }
}
