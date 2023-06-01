package ru.vitnine.aggregationservice.controller

import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.vitnine.aggregationservice.model.CargoDto
import ru.vitnine.aggregationservice.model.request.CargoFilterRequest
import ru.vitnine.aggregationservice.model.request.PageableFilter
import ru.vitnine.aggregationservice.service.CargoAggregationService


@RestController
class CargoController(
    private val cargoAggregationService: CargoAggregationService
) {
    @GetMapping("/")
    fun getHelloWorldMessage(): ResponseEntity<String> {
        return ResponseEntity.ok("Hello from controller")
    }

    @PostMapping("add/cargo")
    fun saveCargo(@RequestBody request: CargoDto): ResponseEntity<String> {
        cargoAggregationService.addCargo(request)
        return ResponseEntity.ok("Cargo information was added successfully")
    }

    @PostMapping("cargo/aggregate")
    fun aggregateByFilter(@RequestBody filter: CargoFilterRequest): List<Any> {
        return cargoAggregationService.aggregateByFilter(filter.toCargoFilter())
    }

    @PostMapping("cargo/filter")
    fun filterCargo(@RequestBody filter: PageableFilter): List<CargoDto> {
        val paging: Pageable = PageRequest.of(filter.page, filter.size)
        return cargoAggregationService.filterCargo(paging)
    }
}
