package com.red.multipleviewholder.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.red.multipleviewholder.model.Component
import com.red.multipleviewholder.model.ComponentType
import com.red.multipleviewholder.ui.adapters.viewholders.FiltersViewHolder
import com.red.multipleviewholder.ui.adapters.viewholders.InputSearchViewHolder
import com.red.multipleviewholder.ui.adapters.viewholders.MediaCardViewHolder
import com.red.multipleviewholder.ui.adapters.viewholders.MediaFeedViewHolder

class ComponentsAdapter(private val components: List<Component>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int = components[position].type.ordinal

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val componentType = ComponentType.values()[viewType]
        val v: View = LayoutInflater.from(parent.context).inflate(componentType.res, parent, false)
        return when (componentType) {
            ComponentType.Search -> InputSearchViewHolder(v)
            ComponentType.Filters -> FiltersViewHolder(v)
            ComponentType.MediaFeed -> MediaFeedViewHolder(v)
            ComponentType.MediaCard -> MediaCardViewHolder(v)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val component = components[position]
        when (component.type) {
            ComponentType.Search -> (holder as InputSearchViewHolder).bind(component.props)
            ComponentType.Filters -> (holder as FiltersViewHolder).bind(component.props)
            ComponentType.MediaFeed -> (holder as MediaFeedViewHolder).bind(component.props)
            ComponentType.MediaCard -> (holder as MediaCardViewHolder).bind(component.props)
        }
    }

    override fun getItemCount(): Int = components.size
}