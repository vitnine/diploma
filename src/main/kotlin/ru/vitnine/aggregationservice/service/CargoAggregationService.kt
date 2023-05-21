package ru.vitnine.aggregationservice.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import ru.vitnine.aggregationservice.model.CargoDto
import ru.vitnine.aggregationservice.model.CargoFilter
import ru.vitnine.aggregationservice.model.FilterPageRequest
import ru.vitnine.aggregationservice.model.request.CargoFilterRequest
import ru.vitnine.aggregationservice.repository.entity.CargoEntity

interface CargoAggregationService {

    fun addCargo(cargo: CargoDto)

    fun aggregateByFilter(filter: FilterPageRequest<CargoFilter>): List<Any>

    fun filterCargo(filter: Pageable): List<CargoDto>
}