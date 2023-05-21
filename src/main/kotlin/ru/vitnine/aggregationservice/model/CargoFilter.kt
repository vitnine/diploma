package ru.vitnine.aggregationservice.model

data class CargoFilter (
    val city: String? = null,
    val minWeight: Int? = null,
    val maxWeight: Int? = null,
    val name: String? = null,
)