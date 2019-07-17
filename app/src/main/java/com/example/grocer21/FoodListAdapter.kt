package com.example.grocer21

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.grocer21.FoodListFragment.OnListFragmentInteractionListener
import com.example.grocer21.database.entities.Foods

/**
 * [RecyclerView.Adapter] that can display a [Foods] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 */
class FoodListAdapter internal constructor(
        context: Context
) : RecyclerView.Adapter<FoodListAdapter.FoodViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var foods = emptyList<Foods>() // Cached copy of foods

    inner class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foodItemView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val itemView = inflater.inflate(R.layout.fragment_food, parent, false)
        return FoodViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val current = foods[position]
        holder.foodItemView.text = current.getName()
    }

    internal fun setFoods(foods: List<Foods>) {
        this.foods = foods
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = foods.size
}