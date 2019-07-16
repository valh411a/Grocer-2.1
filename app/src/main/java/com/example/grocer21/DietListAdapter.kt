package com.example.grocer21

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.grocer21.AllergyListFragment.OnListFragmentInteractionListener
import com.example.grocer21.database.entities.Allergies
import com.example.grocer21.database.entities.Diets

/**
 * [RecyclerView.Adapter] that can display a [Allergies] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 */
class DietListAdapter internal constructor(
        context: Context
) : RecyclerView.Adapter<DietListAdapter.DietViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var diets = emptyList<Diets>() // Cached copy of words

    inner class DietViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dietItemView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DietViewHolder {
        val itemView = inflater.inflate(R.layout.fragment_diet_item, parent, false)
        return DietViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DietViewHolder, position: Int) {
        val current = diets[position]
        holder.dietItemView.text = current.dietType
    }

    internal fun setDiets(diets: List<Diets>) {
        this.diets = diets
        notifyDataSetChanged()
    }

    override fun getItemCount() = diets.size
}