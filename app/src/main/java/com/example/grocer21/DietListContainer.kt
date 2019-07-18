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
 * [DietListContainer.OnDietListContainerInteractionListener] interface
 * to handle interaction events.
 */
class DietListContainer : Fragment() {

    private var mListener: OnDietListContainerInteractionListener? = null


    /**
     * LifeCycle Method
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_diet_list_container, container, false)

        val fab = view.findViewById<FloatingActionButton>(R.id.fab_add_diet)
        fab.setOnClickListener {
            //TODO: handle add diet fragment on FAB click from container
        }
        return view
    }

    /**
     * LifeCycle Method
     */
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnDietListContainerInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException("$context must implement AllergyItemFragmentInteractionListener")
        }
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
    interface OnDietListContainerInteractionListener {
        /**
         * Overridden handler method for interactions on the fragment in the [MainActivity]
         */
        fun onDietListContainerInteraction(uri: Uri)
    }
}// Required empty public constructor
