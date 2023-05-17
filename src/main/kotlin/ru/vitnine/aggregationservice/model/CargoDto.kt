package ru.vitnine.aggregationservice.model

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import ru.vitnine.aggregationservice.repository.entity.CargoEntity
import java.util.UUID

@JsonNaming(SnakeCaseStrategy::class)
data class CargoDto (
    val fromPlace: Placement,
    val toPlace: Placement,
    val fossil: Fossil
) {
    fun toCargoEntity(): CargoEntity {
        return CargoEntity(
            id = UUID.randomUUID(),
            fromPlace = fromPlace,
            toPlace = toPlace,
            fossil = fossil
        )
    }
}

@JsonNaming(SnakeCaseStrategy::class)
data class Fossil (
    val name: String,
    val weight: Double,
    val displacement: Double
)

@JsonNaming(SnakeCaseStrategy::class)
data class Placement (
    val city: String,
    val name: String,
    val address: String
)
