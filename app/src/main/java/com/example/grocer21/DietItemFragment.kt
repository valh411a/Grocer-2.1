package com.example.grocer21

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import java.util.Objects


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [DietItemFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 */
class DietItemFragment : Fragment() {
    private var mListener: OnFragmentInteractionListener? = null
    private var dietName: String? = null

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
        dietName = Objects.requireNonNull(this.arguments).getString("name")

        val databaseViewModel = ViewModelProviders.of(Objects.requireNonNull(activity)).get<DatabaseViewModel>(DatabaseViewModel::class.java!!)
        if (arguments != null) {
            val mColumnCount = arguments!!.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_diet_item, container, false)

        val viewPiece = view.findViewById<TextView>(R.id.dietName)
        viewPiece.text = dietName

        if (savedInstanceState == null) {
            val dietItemFoodList = FoodFragment()
            childFragmentManager
                    .beginTransaction()
                    .add(R.id.list_a_container, dietItemFoodList)
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

        private val ARG_COLUMN_COUNT = "column-count"

        fun newinstance(columnCount: Int): DietItemFragment {
            val fragment = DietItemFragment()
            val args = Bundle()
            args.putInt(ARG_COLUMN_COUNT, columnCount)
            fragment.arguments = args
            return fragment
        }
    }
}// Required empty public constructor
