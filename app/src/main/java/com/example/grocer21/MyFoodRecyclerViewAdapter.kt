package com.example.grocer21

import android.arch.lifecycle.LiveData
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.grocer22.model.Database.Food
import com.example.grocer21.FoodFragment.OnListFragmentInteractionListener
import java.util.Objects

/**
 * [RecyclerView.Adapter] that can display a [Food] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 */
class MyFoodRecyclerViewAdapter(private val foodList: LiveData<List<Food>>, private val mListener: OnListFragmentInteractionListener?) : RecyclerView.Adapter<MyFoodRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_food, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mItem = Objects.requireNonNull<List<Food>>(foodList.value)[position]
        holder.mIdView.setText(foodList.value!![position].getName())

        holder.mView.setOnClickListener {
            mListener?.onListFragmentInteraction(holder.mItem)
        }
    }

    override fun getItemCount(): Int {
        return Objects.requireNonNull<List<Food>>(foodList.value).size
    }

    inner class ViewHolder internal constructor(internal val mView: View) : RecyclerView.ViewHolder(mView) {
        internal val mIdView: TextView
        internal var mItem: Food? = null

        init {
            mIdView = mView.findViewById(R.id.item_number)
        }

        override fun toString(): String {
            return super.toString() + " '" + "'"
        }
    }
}
