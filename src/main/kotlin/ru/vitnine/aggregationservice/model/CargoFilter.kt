package ru.vitnine.aggregationservice.model

data class CargoFilter (
    val minWeight: Double?,
    val maxWeight: Double?,
    val name: String? = "Железо"
)