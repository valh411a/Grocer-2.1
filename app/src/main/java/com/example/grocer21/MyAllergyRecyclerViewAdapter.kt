package com.example.grocer21

import android.arch.lifecycle.LiveData
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.grocer21.AllergyFragment.OnListFragmentInteractionListener
import com.example.grocer22.model.Database.Allergy
import java.util.Objects

/**
 * [RecyclerView.Adapter] that can display a [Allergy] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 */
class MyAllergyRecyclerViewAdapter(private val allergyList: LiveData<List<Allergy>>, private val mListener: OnListFragmentInteractionListener?) : RecyclerView.Adapter<MyAllergyRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_allergy, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mItem = Objects.requireNonNull<List<Allergy>>(allergyList.value)[position]
        holder.mIdView.setText(allergyList.value!![position].getName())

        holder.mView.setOnClickListener {
            mListener?.onListFragmentInteraction(holder.mItem)
        }
    }

    override fun getItemCount(): Int {
        return Objects.requireNonNull<List<Allergy>>(allergyList.value).size
    }

    inner class ViewHolder internal constructor(internal val mView: View) : RecyclerView.ViewHolder(mView) {
        internal val mIdView: TextView
        internal var mItem: Allergy? = null

        init {
            mIdView = mView.findViewById(R.id.item_number)
        }

        override fun toString(): String {
            return super.toString() + " '" + "'"
        }
    }
}
