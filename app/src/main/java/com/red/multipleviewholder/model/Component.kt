package com.red.multipleviewholder.model

import androidx.annotation.LayoutRes
import com.google.gson.reflect.TypeToken
import com.red.multipleviewholder.R
import com.red.multipleviewholder.utils.gsonComponent
import java.lang.reflect.Type

enum class ComponentType(@LayoutRes val res: Int) {
    Search(R.layout.item_component_input_search),
    Filters(R.layout.item_component_filters),
    MediaFeed(R.layout.item_component_media_feed),
    MediaCard(R.layout.item_component_media_card),
}

typealias Properties = Map<String, Any>

fun <T : Any> Properties.getOrNull(key: String): T? {
    return try {
        @Suppress("UNCHECKED_CAST")
        get(key)?.let { it as? T }
    } catch (e: Exception) {
        null
    }
}

fun Properties.getString(key: String) = getOrNull<String>(key)
fun Properties.getInt(key: String) = getOrNull<Int>(key)
fun Properties.getBoolean(key: String) = getOrNull<Boolean>(key)

fun Any.toContents(): List<Component> {
    return try {
        val list = this as List<*>
        val json: Type = object : TypeToken<List<Component>>() {}.type
        gsonComponent.fromJson(gsonComponent.toJson(list), json)
    } catch (e: Exception) {
        emptyList()
    }
}

data class Component(val type: ComponentType, val props: Properties?)