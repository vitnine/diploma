package ru.vitnine.aggregationservice.repository.impl

import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.aggregation.*
import org.springframework.data.mongodb.core.aggregation.Aggregation.*
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Criteria.where
import org.springframework.stereotype.Repository
import ru.vitnine.aggregationservice.model.CargoFilter
import ru.vitnine.aggregationservice.model.FilterPageRequest
import ru.vitnine.aggregationservice.grouping.GroupingType
import ru.vitnine.aggregationservice.grouping.GroupingOperationObject
import ru.vitnine.aggregationservice.repository.CargoAggregationRepository
import ru.vitnine.aggregationservice.repository.entity.CargoEntity


@Repository
class CargoAggregationRepositoryImpl(
    val mongoTemplate: MongoTemplate,
    val groupingOperationObject: Set<GroupingOperationObject>
): CargoAggregationRepository {
    override fun aggregate(filter: FilterPageRequest<CargoFilter>): List<Any>? {
        val matchOperation: MatchOperation = getMatchOperation(filter.filter)
        val skipOperation: SkipOperation = getSkipOperation(filter.page.toLong(), filter.size.toLong())
//        val limitOperation: LimitOperation = getLimitOperation(filter.size.toLong())
        val limitOperation: LimitOperation? = null
        val sortOperation: SortOperation = getSortOperation(filter.sortType)
        val groupOperation: GroupOperation? = filter.groupingType?.let { getGroupOperation(it) }
        val projectionOperation: ProjectionOperation? = filter.groupingType?.let { getProjectOperation(it) }

        return mongoTemplate.aggregate(newAggregation(
            matchOperation,
//            skipOperation,
//            limitOperation?.let { it },
//            if (sortOperation == Sort.unsorted()) null else sortOperation,
            groupOperation,
//            projectionOperation
        ),
            CargoEntity::class.java,
            Any::class.java).mappedResults
    }

    private fun getMatchOperation(mongoFilter: CargoFilter): MatchOperation {
        val criterias = mutableListOf<Criteria>()
        mongoFilter.minWeight?.let { criterias.add(where("fossil.weight").gte(it)) }
        mongoFilter.maxWeight?.let { criterias.add(where("fossil.weight").lte(it)) }
        mongoFilter.name?.let { criterias.add(where("fossil.name").`is`(it)) }
        mongoFilter.city?.let { criterias.add(where("fossil.city").`is`(it)) }
        val criteria = if (criterias.isNotEmpty()) Criteria().andOperator(*criterias.toTypedArray()) else Criteria()

        return match(criteria)
    }

    private fun getGroupOperation(type: GroupingType): GroupOperation {
        val chosenGroupOperation = groupingOperationObject.filter { it.getGroupingType() == type }.toSet().first()
        return chosenGroupOperation.getGroupOperation()
    }

    private fun getProjectOperation(type: GroupingType): ProjectionOperation {
        val chosenGroupOperation = groupingOperationObject.filter { it.getGroupingType() == type }.toSet().first()
        return chosenGroupOperation.getProjectOperation()
    }

    private fun getSkipOperation(page: Long, size: Long): SkipOperation {
        return skip(page * size)
    }

    private fun getLimitOperation(size: Long): LimitOperation {
        return limit(size)
    }

    private fun getSortOperation(sort: Sort): SortOperation {
        return sort(sort)
    }
}