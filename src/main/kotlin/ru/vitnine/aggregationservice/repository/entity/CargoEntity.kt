package ru.vitnine.aggregationservice.repository.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import ru.vitnine.aggregationservice.model.Fossil
import ru.vitnine.aggregationservice.model.Placement
import java.util.UUID

@Document(collection = "cargo")
data class CargoEntity(
    @Id
    val id: UUID,
    val fromPlace: Placement,
    val toPlace: Placement,
    val fossil: Fossil
)