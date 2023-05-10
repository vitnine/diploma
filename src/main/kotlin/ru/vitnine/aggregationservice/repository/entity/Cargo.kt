package ru.vitnine.aggregationservice.repository.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.UUID

@Document
data class Cargo (
    @Id
    val id: UUID,
    val fromPlace: Placement,
    val toPlace: Placement,
    val fossil: Fossil
) {
    data class Fossil(
        val name: String,
        val weight: Double,
        val displacement: Double
    )

    data class Placement(
        val city: String,
        val name: String,
        val address: String
    )
}