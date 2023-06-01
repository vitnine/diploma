package ru.vitnine.aggregationservice.service

import ru.vitnine.aggregationservice.model.CargoDto
import ru.vitnine.aggregationservice.model.CargoFilter
import ru.vitnine.aggregationservice.model.FilterPageRequest

interface CargoAggregationService {

    fun addCargo(cargo: CargoDto)

    fun aggregateByFilter(filter: FilterPageRequest<CargoFilter>): List<Any>
}