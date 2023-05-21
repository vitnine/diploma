package ru.vitnine.aggregationservice.repository

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository
import ru.vitnine.aggregationservice.repository.entity.CargoEntity
import java.util.UUID

@Repository
interface CargoRepository : MongoRepository<CargoEntity, UUID>, CargoAggregationRepository, PagingAndSortingRepository<CargoEntity, UUID> {

}