package com.red.multipleviewholder.utils

import com.google.gson.*
import com.red.multipleviewholder.model.ComponentType
import java.lang.reflect.Type

val gsonComponent: Gson = GsonBuilder()
    .registerTypeAdapter(ComponentType::class.java, ComponentTypeConverter())
    .create()

class ComponentTypeConverter : JsonSerializer<ComponentType?>,

    JsonDeserializer<ComponentType?> {
    override fun serialize(
        src: ComponentType?,
        typeOfSrc: Type?,
        context: JsonSerializationContext?,
    ): JsonElement = JsonPrimitive(
        when (src) {
            ComponentType.Search -> "input_search"
            ComponentType.Filters -> TODO()
            ComponentType.MediaFeed -> "media_feed"
            ComponentType.MediaCard -> "media_card"
            null -> null
        }
    )

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?,
    ): ComponentType? {
        return json?.asString?.let {
            when (it) {
                "input_search" -> ComponentType.Search
                "filters" -> ComponentType.Filters
                "media_feed" -> ComponentType.MediaFeed
                "media_card" -> ComponentType.MediaCard
                else -> null
            }
        }
    }

}