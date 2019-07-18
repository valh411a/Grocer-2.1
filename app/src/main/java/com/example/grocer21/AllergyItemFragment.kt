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
 * [AllergyItemFragment.AllergyItemFragmentInteractionListener] interface
 * to handle interaction events.
 */
class AllergyItemFragment : Fragment() {
    private var mListener: AllergyItemFragmentInteractionListener? = null
    private var allergyName: String? = null

    /**
     * Lifecycle method for fragment attach to [MainActivity]
     */
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is AllergyItemFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException("$context must implement AllergyItemFragmentInteractionListener")
        }
    }

    /**
     * Lifecycle method for fragment creation
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        allergyName = (this.arguments)?.getString("name")

        (activity)?.let { ViewModelProviders.of(it).get(DatabaseViewModel::class.java) }
        if (arguments != null) {
            (arguments ?: return).getInt(ARG_COLUMN_COUNT)
        }
    }

    /**
     * Lifecycle method for the creation of the fragment's view
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_allergy_item, container, false)

        val viewPiece = view.findViewById<TextView>(R.id.allergy_name)
        viewPiece.text = allergyName

        if (savedInstanceState == null) {
            val allergyFoodList = FoodListFragment()
            childFragmentManager
                    .beginTransaction()
                    .add(R.id.list_container, allergyFoodList)
                    .commit()
        }

        return view
    }

    /**
     * Lifecycle method for the detachment of the fragment from the [MainActivity]
     */
    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    /**
     * Listener method for the fragment's interaction
     *
     * this is generalized, and will be renamed if a more relevant usage is found
     */
    interface AllergyItemFragmentInteractionListener {
        /**
         * Overridden method for the fragment's interaction.
         *
         * generalized ([AllergyItemFragmentInteractionListener])
         */
        fun onAllergyFragmentInteraction()
    }

    companion object {

        private const val ARG_COLUMN_COUNT = "column-count"

    }
}// Required empty public constructor
