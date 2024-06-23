package dev.josegaldamez.themeschats.utils

import dev.josegaldamez.themeschats.models.MessageData

val listOfResponses = listOf<String>(
    "Hola",
    "Que tal",
    "Buen dia",
    "Adios",
    "Que bien",
    "Que mal",
    "Un gusto",
    "No me digas",
    "No me gusta",
    "Eso me encanta"
)

fun automaticResponse() : MessageData {
    val randomResponse = listOfResponses.random()

    val response = MessageData(
        isMine = false,
        text = randomResponse
    )

    return response

}
