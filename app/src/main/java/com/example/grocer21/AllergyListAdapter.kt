package com.example.grocer21

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.grocer21.AllergyListFragment.OnAllergyListFragmentInteractionListener
import com.example.grocer21.database.entities.Allergies

/**
 * [RecyclerView.Adapter] that can display a [Allergies] and makes a call to the
 * specified [OnAllergyListFragmentInteractionListener].
 */
class AllergyListAdapter internal constructor(
        context: Context
) : RecyclerView.Adapter<AllergyListAdapter.AllergyViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var allergies = emptyList<Allergies>() // Cached copy of words

    /**
     * Class representing the view which holds the allergy recyclerview
     */
    inner class AllergyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        /**
         * textview value that is used to bind values to each slot in the list
         */
        val allergyItemView: TextView = itemView.findViewById(R.id.textView)
    }

    /**
     * Lifecycle method that handles the creation of the [AllergyViewHolder]
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllergyViewHolder {
        val itemView = inflater.inflate(R.layout.fragment_allergy_item, parent, false)
        return AllergyViewHolder(itemView)
    }

    /**
     * Lifecycle method that handles the binding of the values into the allergyItemView
     */
    override fun onBindViewHolder(holder: AllergyViewHolder, position: Int) {
        val current = allergies[position]
        holder.allergyItemView.text = current.allergyType
    }

    internal fun setAllergies(allergies: List<Allergies>) {
        this.allergies = allergies
        notifyDataSetChanged()
    }

    /**
     * Lifecycle method that gets the number of allergies in the [Allergies] table
     * (Currently not needed, but is a required abstract method for the [RecyclerView] class)
     */
    override fun getItemCount(): Int = allergies.size
}