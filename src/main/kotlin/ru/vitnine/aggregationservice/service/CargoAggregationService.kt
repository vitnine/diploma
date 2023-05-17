package ru.vitnine.aggregationservice.service

import ru.vitnine.aggregationservice.model.CargoDto

interface CargoAggregationService {

    fun addCargo(cargo: CargoDto)

    fun aggregateByWeight(min: Double?, max:Double?): List<CargoDto>
}