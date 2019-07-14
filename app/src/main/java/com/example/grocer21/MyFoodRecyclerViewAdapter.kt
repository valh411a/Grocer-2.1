package com.example.grocer21

import android.arch.lifecycle.LiveData
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.grocer21.FoodFragment.OnListFragmentInteractionListener
import com.example.grocer21.database.entities.Foods
import java.util.Objects

/**
 * [RecyclerView.Adapter] that can display a [Foods] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 */
class MyFoodRecyclerViewAdapter(private val foodList: LiveData<List<Foods>>, private val mListener: OnListFragmentInteractionListener?) : RecyclerView.Adapter<MyFoodRecyclerViewAdapter.ViewHolder>() {

    private var foods = emptyList<Foods>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_food, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mItem = Objects.requireNonNull<List<Foods>>(foodList.value)[position]
        holder.mIdView.text = foodList.value!![position].getName()

        holder.mView.setOnClickListener {
            mListener?.onListFragmentInteraction(holder.mItem!!)
        }
    }

    internal fun setFoods(foods: List<Foods>) {
        this.foods = foods
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return Objects.requireNonNull<List<Foods>>(foodList.value).size
    }

    inner class ViewHolder internal constructor(internal val mView: View) : RecyclerView.ViewHolder(mView) {
        internal val mIdView: TextView = mView.findViewById(R.id.item_number)
        internal var mItem: Foods? = null

        override fun toString(): String {
            return super.toString() + " '" + "'"
        }
    }
}
