package com.red.multipleviewholder.ui.adapters.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.red.multipleviewholder.R
import com.red.multipleviewholder.model.Properties
import com.red.multipleviewholder.model.getOrNull

class FiltersViewHolder(private val v: View) : RecyclerView.ViewHolder(v) {
    private var chipGroup: ChipGroup = v.findViewById(R.id.chipGroup)

    fun bind(prop: Properties?) {
        prop?.getOrNull<List<String>>("items")?.let { list ->
            list.forEach {
                val chip = Chip(v.context)
                chip.text = it
                chipGroup.addView(chip)
            }
        }
    }

}