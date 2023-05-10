package ru.vitnine.aggregationservice.controller

import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.slf4j.Logger
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import ru.vitnine.aggregationservice.model.SaveCargoRequest
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
    fun saveCargo(@RequestBody request: SaveCargoRequest): ResponseEntity<String> {
        cargoAggregationService.addCargo(request.toCargoDto())
        return ResponseEntity.ok("Cargo information was added successfully")
    }
}
