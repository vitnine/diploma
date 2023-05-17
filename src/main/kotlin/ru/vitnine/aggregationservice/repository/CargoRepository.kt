package ru.vitnine.aggregationservice.repository

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import ru.vitnine.aggregationservice.repository.entity.CargoEntity

@Repository
interface CargoRepository : MongoRepository<CargoEntity, String>, CargoAggregationRepository {

}