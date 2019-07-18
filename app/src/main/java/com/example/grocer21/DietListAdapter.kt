package com.example.grocer21

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.grocer21.AllergyListFragment.OnAllergyListFragmentInteractionListener
import com.example.grocer21.database.entities.Allergies
import com.example.grocer21.database.entities.Diets

/**
 * [RecyclerView.Adapter] that can display a [Allergies] and makes a call to the
 * specified [OnAllergyListFragmentInteractionListener].
 */
class DietListAdapter internal constructor(
        context: Context
) : RecyclerView.Adapter<DietListAdapter.DietViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var diets = emptyList<Diets>() // Cached copy of words

    /**
     * RecyclerView abstract method implementation
     */
    inner class DietViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        /**
         * RecyclerView abstract method implementation
         */
        val dietItemView: TextView = itemView.findViewById(R.id.textView)
    }

    /**
     * RecyclerView abstract method implementation
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DietViewHolder {
        val itemView = inflater.inflate(R.layout.fragment_diet_item, parent, false)
        return DietViewHolder(itemView)
    }

    /**
     * RecyclerView abstract method implementation
     */
    override fun onBindViewHolder(holder: DietViewHolder, position: Int) {
        val current = diets[position]
        holder.dietItemView.text = current.dietType
    }

    internal fun setDiets(diets: List<Diets>) {
        this.diets = diets
        notifyDataSetChanged()
    }

    /**
     * RecyclerView abstract method implementation
     */
    override fun getItemCount(): Int = diets.size
}