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
import com.example.grocer21.database.entities.Diets

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
class DietListFragment : Fragment() {
    private var mColumnCount = 1
    private var mListener: OnDietListFragmentInteractionListener? = null
    private var databaseViewModel: DatabaseViewModel? = null

    /**
     * LifeCycle Method
     */
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnDietListFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException("$context must implement OnAllergyListFragmentInteractionListener")
        }
    }

    /**
     * LifeCycle Method
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
     * LifeCycle Method
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_diet_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            val context = view.getContext()
            if (mColumnCount <= 1) {
                view.layoutManager = LinearLayoutManager(context)
            } else {
                view.layoutManager = GridLayoutManager(context, mColumnCount)
            }
            view.addItemDecoration(DividerItemDecoration(view.context, VERTICAL))
            view.adapter = this.context?.let { DietListAdapter(it) }
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
     * Listener method for interactions on the fragment in the [MainActivity]
     */
    interface OnDietListFragmentInteractionListener {
        /**
         * Overridden handler method for interactions on the fragment in the [MainActivity]
         */
        fun onDietListFragmentInteraction(item: Diets)
    }

    companion object {

        private const val ARG_COLUMN_COUNT = "column-count"

    }
}
