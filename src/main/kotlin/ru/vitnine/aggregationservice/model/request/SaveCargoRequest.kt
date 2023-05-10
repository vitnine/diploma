package ru.vitnine.aggregationservice.model

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming


@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class SaveCargoRequest(
    val fromPlace: Placement,
    val toPlace: Placement,
    val fossil: Fossil
) {
    data class Fossil(
        val name: String,
        val weight: Double,
        val displacement: Double
    ) {
        fun toFossilDto(): CargoDto.Fossil {
            return CargoDto.Fossil(
                name = name,
                weight = weight,
                displacement = displacement
            )
        }
    }

    data class Placement(
        val city: String,
        val name: String,
        val address: String
    ) {
        fun toPlacementDto() : CargoDto.Placement {
            return CargoDto.Placement(
                city = city,
                name = name,
                address = address
            )
        }
    }

    fun toCargoDto(): CargoDto {
        return CargoDto(
            fromPlace = fromPlace.toPlacementDto(),
            toPlace = toPlace.toPlacementDto(),
            fossil = fossil.toFossilDto()
        )
    }
}