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
 * [DietItemFragment.OnDietItemFragmentInteractionListener] interface
 * to handle interaction events.
 */
class DietItemFragment : Fragment() {
    private var mListener: OnDietItemFragmentInteractionListener? = null
    private var dietName: String? = null

    /**
     * Lifecycle Method
     */
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnDietItemFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException("$context must implement AllergyItemFragmentInteractionListener")
        }
    }

    /**
     * Lifecycle Method
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dietName = (this.arguments)?.getString("name")

        (activity)?.let { ViewModelProviders.of(it).get(DatabaseViewModel::class.java) }
        if (arguments != null) {
            (arguments ?: return).getInt(ARG_COLUMN_COUNT)
        }
    }

    /**
     * Lifecycle Method
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_diet_item, container, false)

        val viewPiece = view.findViewById<TextView>(R.id.dietName)
        viewPiece.text = dietName

        if (savedInstanceState == null) {
            val dietItemFoodList = FoodListFragment()
            childFragmentManager
                    .beginTransaction()
                    .add(R.id.list_a_container, dietItemFoodList)
                    .commit()
        }

        return view
    }

    /**
     * Lifecycle Method
     */
    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    /**
     * Listener for interactions of the [DietItemFragment] on the [MainActivity]
     */
    interface OnDietItemFragmentInteractionListener {
        /**
         * Overridden method that handles interactions on the [MainActivity]
         */
        fun onDietItemFragmentInteraction()
    }

    companion object {

        private const val ARG_COLUMN_COUNT = "column-count"

    }
}// Required empty public constructor
