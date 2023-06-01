package ru.vitnine.aggregationservice.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.vitnine.aggregationservice.model.CargoDto
import ru.vitnine.aggregationservice.model.request.CargoFilterRequest
import ru.vitnine.aggregationservice.service.CargoAggregationService


@RestController
class CargoController(
    private val cargoAggregationService: CargoAggregationService
) {
    @PostMapping("add/cargo")
    fun saveCargo(@RequestBody request: CargoDto): ResponseEntity<String> {
        cargoAggregationService.addCargo(request)
        return ResponseEntity.ok("Cargo information was added successfully")
    }

    @PostMapping("cargo/aggregate")
    fun aggregateByFilter(@RequestBody filter: CargoFilterRequest): List<Any> {
        return cargoAggregationService.aggregateByFilter(filter.toCargoFilter())
    }
}
