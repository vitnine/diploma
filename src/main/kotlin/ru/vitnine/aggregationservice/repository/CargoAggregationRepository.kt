package ru.vitnine.aggregationservice.repository

import ru.vitnine.aggregationservice.model.CargoDto

interface CargoAggregationRepository {
    fun aggregate(minWeight: Double?, maxWeight: Double?): List<CargoDto>?
}