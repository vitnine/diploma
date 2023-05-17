package ru.vitnine.aggregationservice.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.vitnine.aggregationservice.model.CargoDto
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

    @GetMapping("cargo/aggregate_weight")
    fun aggregateByWeight(@RequestParam min: Double?, max:Double?): List<CargoDto> {
        return cargoAggregationService.aggregateByWeight(min, max)
    }
}
