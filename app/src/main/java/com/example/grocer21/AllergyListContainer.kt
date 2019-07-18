package com.example.grocer21

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [AllergyListContainer.OnAllergyListContainerInteractionListener] interface
 * to handle interaction events.
 */
class AllergyListContainer : Fragment() {

    private var mListener: OnAllergyListContainerInteractionListener? = null


    /**
     * Lifecycle method that creates the view that the fragment is bound to
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_allergy_list_container, container, false)

        val fab = view.findViewById<FloatingActionButton>(R.id.fab_add_allergy)
        fab.setOnClickListener {
            //TODO: handle add allergy fragment on FAB click from container
        }
        return view
    }

    /**
     *
     */
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnAllergyListContainerInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException("$context must implement AllergyItemFragmentInteractionListener")
        }
    }

    /**
     * Lifecycle method for the detachment from the [MainActivity]
     */
    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    /**
     * Listener for interactions on the fragment
     *
     * generalized
     */
    interface OnAllergyListContainerInteractionListener {
        /**
         * Overridden function that handles the fragment's interaction in the [MainActivity]
         *
         * generalized
         */
        fun onAllergyListContainerInteraction(uri: Uri)
    }
}// Required empty public constructor
