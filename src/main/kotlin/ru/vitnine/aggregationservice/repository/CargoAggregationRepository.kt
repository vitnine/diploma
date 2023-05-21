package ru.vitnine.aggregationservice.repository

import ru.vitnine.aggregationservice.model.CargoFilter
import ru.vitnine.aggregationservice.model.FilterPageRequest

interface CargoAggregationRepository {
    fun aggregate(filter: FilterPageRequest<CargoFilter>): List<Any>?
}