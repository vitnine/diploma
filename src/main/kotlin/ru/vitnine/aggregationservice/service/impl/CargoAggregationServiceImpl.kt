package ru.vitnine.aggregationservice.service.impl

import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import ru.vitnine.aggregationservice.model.CargoDto
import ru.vitnine.aggregationservice.model.CargoFilter
import ru.vitnine.aggregationservice.model.FilterPageRequest
import ru.vitnine.aggregationservice.repository.CargoRepository
import ru.vitnine.aggregationservice.service.CargoAggregationService

@Service
class CargoAggregationServiceImpl(
    private val cargoRepository: CargoRepository
): CargoAggregationService {
    override fun addCargo(cargo: CargoDto) {
        cargoRepository.save(cargo.toCargoEntity())
    }

    override fun aggregateByFilter(filter: FilterPageRequest<CargoFilter>): List<Any> {
        return cargoRepository.aggregate(filter) ?: emptyList()
    }

    override fun filterCargo(filter: Pageable): List<CargoDto> {
        return cargoRepository.findAll(filter).content.map { it.toCargoDto() }
    }
}