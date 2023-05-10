package ru.vitnine.aggregationservice.service.impl

import org.springframework.stereotype.Service
import ru.vitnine.aggregationservice.model.CargoDto
import ru.vitnine.aggregationservice.repository.CargoRepository
import ru.vitnine.aggregationservice.service.CargoAggregationService

@Service
class CargoAggregationServiceImpl(
    private val cargoRepository: CargoRepository
): CargoAggregationService {
    override fun addCargo(cargo: CargoDto) {
        cargoRepository.save(cargo.toCargoEntity())
    }
}