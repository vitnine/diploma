package ru.vitnine.aggregationservice.model

data class CargoFilter (
    val minWeight: Int? = null,
    val maxWeight: Int? = null,
    val name: String? = null,
    val fromCity: String? = null,
    val toCity: String? = null,
)