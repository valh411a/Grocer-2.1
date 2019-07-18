package com.example.grocer21

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [HomeScreenFragment.OnHomeScreenFragmentInteractionListener] interface
 * to handle interaction events.
 */
class HomeScreenFragment : Fragment() {

    private var mListener: OnHomeScreenFragmentInteractionListener? = null

    /**
     * Lifecycle method
     */
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnHomeScreenFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException("$context must implement AllergyItemFragmentInteractionListener")
        }
    }

    /**
     * Lifecycle method
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        (activity)?.title = "Home"
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_screen, container, false)
    }

    /**
     * Lifecycle method
     */
    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    /**
     * Listener for handling interactions on the fragment in the [MainActivity]
     */
    interface OnHomeScreenFragmentInteractionListener {
        /**
         * Overridden handler method in the [MainActivity]
         */
        fun onHomeScreenFragmentInteraction()
    }
}// Required empty public constructor
