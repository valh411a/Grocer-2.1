package com.example.grocer21

import android.arch.lifecycle.LiveData
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.grocer21.DietFragment.OnListFragmentInteractionListener
import com.example.grocer21.database.entities.Diets
import java.util.Objects

/**
 * [RecyclerView.Adapter] that can display a [Diets] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 */
class MyDietRecyclerViewAdapter internal constructor(private val dietList: LiveData<List<Diets>>, private val mListener: OnListFragmentInteractionListener?) : RecyclerView.Adapter<MyDietRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_diet, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mItem = Objects.requireNonNull<List<Diets>>(dietList.value)[position]
        holder.mIdView.text = dietList.value!![position].getName()

        holder.mView.setOnClickListener {
            mListener?.onListFragmentInteraction(holder.mItem!!)
        }
    }

    override fun getItemCount(): Int {
        return Objects.requireNonNull<List<Diets>>(dietList.value).size
    }

    inner class ViewHolder internal constructor(internal val mView: View) : RecyclerView.ViewHolder(mView) {
        internal val mIdView: TextView = mView.findViewById(R.id.item_number)
        internal var mItem: Diets? = null

        override fun toString(): String {
            return super.toString() + " '" + "'"
        }
    }
}
