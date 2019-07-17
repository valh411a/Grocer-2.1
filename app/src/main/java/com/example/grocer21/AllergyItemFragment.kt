package com.example.grocer21

import androidx.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import java.util.Objects


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [AllergyItemFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 */
class AllergyItemFragment : Fragment() {
    private var mListener: OnFragmentInteractionListener? = null
    private var allergyName: String? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        allergyName = (this.arguments)?.getString("name")

        (activity)?.let { ViewModelProviders.of(it).get(DatabaseViewModel::class.java) }
        if (arguments != null) {
            arguments!!.getInt(ARG_COLUMN_COUNT)
        }
    }

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

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html) for more information.
     */
    interface OnFragmentInteractionListener {
        fun onFragmentInteraction()
    }

    companion object {

        private const val ARG_COLUMN_COUNT = "column-count"

    }
}// Required empty public constructor
