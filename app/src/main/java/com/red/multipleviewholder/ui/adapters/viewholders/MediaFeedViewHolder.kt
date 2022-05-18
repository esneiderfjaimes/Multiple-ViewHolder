package com.red.multipleviewholder.ui.adapters.viewholders

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.red.multipleviewholder.R
import com.red.multipleviewholder.model.Properties
import com.red.multipleviewholder.model.getOrNull
import com.red.multipleviewholder.model.toContents
import com.red.multipleviewholder.ui.adapters.ComponentsAdapter

class MediaFeedViewHolder(private val v: View) : RecyclerView.ViewHolder(v) {
    private val recycler = v.findViewById<RecyclerView>(R.id.components_recycler)

    fun bind(prop: Properties?) {
        prop?.getOrNull<Map<*, *>>("content")?.let { content ->
            val items = content["items"] ?: return

            val adapter = ComponentsAdapter(items.toContents())
            val layoutManager = object : LinearLayoutManager(v.context) {
                override fun canScrollVertically(): Boolean = false
            }

            recycler.adapter = adapter
            recycler.layoutManager = layoutManager
            recycler.adapter
        }
    }

}