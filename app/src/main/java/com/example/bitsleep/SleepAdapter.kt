package com.example.bitsleep

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SleepAdapter(private val sleepEntries: List<SleepEntry>) :
    RecyclerView.Adapter<SleepAdapter.SleepViewHolder>() {

    inner class SleepViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dateText: TextView = view.findViewById(R.id.dateText)
        val hoursText: TextView = view.findViewById(R.id.hoursText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SleepViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_sleep_entry, parent, false)
        return SleepViewHolder(view)
    }

    override fun onBindViewHolder(holder: SleepViewHolder, position: Int) {
        val entry = sleepEntries[position]
        holder.dateText.text = entry.date
        holder.hoursText.text = "${entry.hoursSlept} hours"
    }

    override fun getItemCount() = sleepEntries.size
}
