package com.example.grocer21

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout.VERTICAL
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.grocer21.database.entities.Allergies

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
class AllergyListFragment : Fragment() {
    private var databaseViewModel: DatabaseViewModel? = null
    private var mColumnCount = 1
    private var mListener: OnAllergyListFragmentInteractionListener? = null

    /**
     * Lifecycle method
     */
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnAllergyListFragmentInteractionListener) {
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

        databaseViewModel = (activity)?.let {
            ViewModelProviders.of(it).get(DatabaseViewModel::class.java)
        }
        if (arguments != null) {
            mColumnCount = (arguments ?: return).getInt(ARG_COLUMN_COUNT)
        }


    }

    /**
     * Lifecycle method
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_allergy_list, container, false)


        // Set the adapter
        if (view is RecyclerView) {
            val context = view.getContext()
            if (mColumnCount <= 1) {
                view.layoutManager = LinearLayoutManager(context)
            } else {
                view.layoutManager = GridLayoutManager(context, mColumnCount)
            }
            view.addItemDecoration(DividerItemDecoration(view.context, VERTICAL))
            view.adapter = this.context?.let { AllergyListAdapter(it) }
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
     * Listener for interactions on the fragment
     *
     * @generalized
     */
    interface OnAllergyListFragmentInteractionListener {
        /**
         * Overridden method that handles the interactions with the fragment on the [MainActivity]
         *
         * @generalized
         */
        fun onListFragmentInteraction(item: Allergies)
    }

    companion object {

        private const val ARG_COLUMN_COUNT = "column-count"

    }
}
