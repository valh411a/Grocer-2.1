package com.example.grocer21

import android.arch.lifecycle.LiveData
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.grocer22.model.Database.Diet
import com.example.grocer21.DietFragment.OnListFragmentInteractionListener
import java.util.Objects

/**
 * [RecyclerView.Adapter] that can display a [Diet] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 */
class MyDietRecyclerViewAdapter internal constructor(private val dietList: LiveData<List<Diet>>, private val mListener: OnListFragmentInteractionListener?) : RecyclerView.Adapter<MyDietRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_diet, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mItem = Objects.requireNonNull<List<Diet>>(dietList.value)[position]
        holder.mIdView.setText(dietList.value!![position].getName())

        holder.mView.setOnClickListener {
            mListener?.onListFragmentInteraction(holder.mItem)
        }
    }

    override fun getItemCount(): Int {
        return Objects.requireNonNull<List<Diet>>(dietList.value).size
    }

    inner class ViewHolder internal constructor(internal val mView: View) : RecyclerView.ViewHolder(mView) {
        internal val mIdView: TextView
        internal var mItem: Diet? = null

        init {
            mIdView = mView.findViewById(R.id.item_number)
        }

        override fun toString(): String {
            return super.toString() + " '" + "'"
        }
    }
}
