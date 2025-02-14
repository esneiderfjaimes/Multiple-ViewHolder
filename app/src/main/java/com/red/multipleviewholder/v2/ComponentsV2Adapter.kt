package com.red.multipleviewholder.v2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.red.multipleviewholder.databinding.ItemV2CardBinding
import com.red.multipleviewholder.databinding.ItemV2HeaderBinding

class ComponentsV2Adapter(
    private val components: List<ComponentV2>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int = when (components[position]) {
        is ComponentV2.Header -> 1
        is ComponentV2.Card -> 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if (viewType == 1) {
            HeaderViewHolder(ItemV2HeaderBinding.inflate(inflater, parent, false))
        } else {
            CardViewHolder(ItemV2CardBinding.inflate(inflater, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val component = components[position]) {
            is ComponentV2.Header -> (holder as HeaderViewHolder).bind(component)
            is ComponentV2.Card -> (holder as CardViewHolder).bind(component)
        }
    }

    override fun getItemCount(): Int = components.size

    class HeaderViewHolder(
        private val binding: ItemV2HeaderBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(component: ComponentV2.Header) {
            binding.title.text = component.label
        }
    }

    class CardViewHolder(
        private val binding: ItemV2CardBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(component: ComponentV2.Card) {
            binding.title.text = component.amount
        }
    }
}