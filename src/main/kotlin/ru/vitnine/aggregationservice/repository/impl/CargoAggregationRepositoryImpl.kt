package ru.vitnine.aggregationservice.repository.impl

import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.aggregate
import org.springframework.data.mongodb.core.aggregation.Aggregation.match
import org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation
import org.springframework.data.mongodb.core.aggregation.MatchOperation
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Criteria.where
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component
import ru.vitnine.aggregationservice.model.CargoDto
import ru.vitnine.aggregationservice.model.CargoFilter
import ru.vitnine.aggregationservice.repository.CargoAggregationRepository
import ru.vitnine.aggregationservice.repository.entity.CargoEntity


@Component
class CargoAggregationRepositoryImpl(
    val mongoTemplate: MongoTemplate
): CargoAggregationRepository {
    override fun aggregate(minWeight: Double?, maxWeight: Double?): List<CargoDto>? {
        val matchOperation: MatchOperation = getMatchOperation(CargoFilter(minWeight, maxWeight))
//        val groupOperation: GroupOperation = getGroupOperation()
//        val projectionOperation: ProjectionOperation = getProjectOperation()
//         return mongoTemplate.aggregate(newAggregation(matchOperation), CargoDto::class.java, CargoDto::class.java).mappedResults
         return mongoTemplate.aggregate(newAggregation(matchOperation), CargoEntity::class.java, CargoDto::class.java).mappedResults
    }

    private fun getMatchOperation(mongoFilter: CargoFilter): MatchOperation {
        val criterias = mutableListOf<Criteria>()
        mongoFilter.minWeight?.let { criterias.add(where("fossil.weight").gt(it)) }
        mongoFilter.maxWeight?.let { criterias.add(where("fossil.weight").lt(it)) }
        mongoFilter.name?.let { criterias.add(where("fossil.name").`is`(it)) }
        return match(Criteria().andOperator(criterias))
    }
}