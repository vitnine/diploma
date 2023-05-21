package ru.vitnine.aggregationservice.grouping

import org.springframework.data.mongodb.core.aggregation.Aggregation.group
import org.springframework.data.mongodb.core.aggregation.Aggregation.project
import org.springframework.data.mongodb.core.aggregation.GroupOperation
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation
import org.springframework.stereotype.Component

@Component
class FromCityGroupingObject: GroupingOperationObject {

    override fun getGroupingType(): GroupingType {
        return GroupingType.FROM_CITY
    }

    override fun getGroupOperation(): GroupOperation {
        return group("fromPlace.city")
            .avg("fossil.weight").`as`("average_weight")
            .sum("fossil.weight").`as`("total_weight")
    }

    override fun getProjectOperation(): ProjectionOperation {
        return project("productIds", "averagePrice", "totalRevenue")
            .and("warehouse").previousOperation();
    }
}