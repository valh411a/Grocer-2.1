package com.example.grocer21

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.grocer21.AllergyListFragment.OnListFragmentInteractionListener
import com.example.grocer21.database.entities.Allergies

/**
 * [RecyclerView.Adapter] that can display a [Allergies] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 */
class AllergyListAdapter internal constructor(
        context: Context
) : RecyclerView.Adapter<AllergyListAdapter.AllergyViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var allergies = emptyList<Allergies>() // Cached copy of words

    inner class AllergyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val allergyItemView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllergyViewHolder {
        val itemView = inflater.inflate(R.layout.fragment_allergy_item, parent, false)
        return AllergyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AllergyViewHolder, position: Int) {
        val current = allergies[position]
        holder.allergyItemView.text = current.allergyType
    }

    internal fun setAllergies(allergies: List<Allergies>) {
        this.allergies = allergies
        notifyDataSetChanged()
    }

    override fun getItemCount() = allergies.size
}