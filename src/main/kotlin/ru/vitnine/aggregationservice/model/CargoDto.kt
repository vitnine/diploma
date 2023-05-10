package ru.vitnine.aggregationservice.model

import ru.vitnine.aggregationservice.repository.entity.Cargo
import java.util.UUID


data class CargoDto (
    val fromPlace: Placement,
    val toPlace: Placement,
    val fossil: Fossil
) {
    data class Fossil (
        val name: String,
        val weight: Double,
        val displacement: Double
    ) {
        fun toFossilEntity(): Cargo.Fossil {
            return Cargo.Fossil(
                name = name,
                weight = weight,
                displacement = displacement
            )
        }
    }

    data class Placement (
        val city: String,
        val name: String,
        val address: String
    ) {
        fun toPlacementEntity() : Cargo.Placement {
            return Cargo.Placement(
                city = city,
                name = name,
                address = address
            )
        }
    }

    fun toCargoEntity(): Cargo {
        return Cargo(
            id = UUID.randomUUID(),
            fromPlace = fromPlace.toPlacementEntity(),
            toPlace = toPlace.toPlacementEntity(),
            fossil = fossil.toFossilEntity()
        )
    }
}
