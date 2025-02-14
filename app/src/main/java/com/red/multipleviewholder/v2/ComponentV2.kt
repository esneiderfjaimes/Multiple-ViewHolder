package com.red.multipleviewholder.v2

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

sealed class ComponentV2 {
    data class Header(val label: String) : ComponentV2()
    data class Card(val amount: String) : ComponentV2()
}

data class CardInfo(val amount: String, val date: LocalDateTime)

val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd MM yyyy")

fun cardInfoToComponentV2(cardInfos: List<CardInfo>): MutableList<ComponentV2> {
    // Agrupar por día
    val groupedByDay = cardInfos.groupBy { it.date.toLocalDate() }
        .toSortedMap(compareByDescending { it }) // Ordenar por fecha descendente

    val components2 = mutableListOf<ComponentV2>()

    groupedByDay.forEach { (date, cards) ->
        if (cards.isEmpty()) {
            return@forEach
        }

        val label = if (isToday(date)) "Today" else formatter.format(date)
        val header = ComponentV2.Header(label)
        components2.add(header)

        cards.forEach { card ->
            val cardComponent = ComponentV2.Card(card.amount)
            components2.add(cardComponent)
        }
    }

    return components2
}

fun isToday(dateTime: LocalDate): Boolean {
    return dateTime == LocalDate.now()
}