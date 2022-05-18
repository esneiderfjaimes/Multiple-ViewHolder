package com.red.multipleviewholder.ui.adapters.viewholders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.red.multipleviewholder.R
import com.red.multipleviewholder.model.Properties
import com.red.multipleviewholder.model.getOrNull

class MediaCardViewHolder(private val v: View) : RecyclerView.ViewHolder(v) {
    private val card = v.findViewById<MaterialCardView>(R.id.card)
    private val title = v.findViewById<TextView>(R.id.title)
    private val subtitle = v.findViewById<TextView>(R.id.subtitle)

    fun bind(prop: Properties?) {
        prop?.getOrNull<Map<*, *>>("content")?.let { content ->
            val description = content["description"] as Map<*, *>
            (description["title"] as Map<*, *>).run {
                (get("props") as Map<*, *>).let {
                    val s = it["label"] as String
                    title.text = s
                }
            }
            (description["subtitle"] as Map<*, *>).run {
                (get("props") as Map<*, *>).let {
                    val s = it["label"] as String
                    subtitle.text = s
                }
            }
        }
    }

}