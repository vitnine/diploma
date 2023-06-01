package ru.vitnine.aggregationservice.grouping

import org.springframework.data.mongodb.core.aggregation.Aggregation.group
import org.springframework.data.mongodb.core.aggregation.Aggregation.project
import org.springframework.data.mongodb.core.aggregation.GroupOperation
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation
import org.springframework.stereotype.Component

@Component
class FromCityGrouping: GroupingOperation {

    override fun getGroupingType(): GroupingType {
        return GroupingType.FROM_CITY
    }

    override fun getGroupOperation(): GroupOperation {
        return group("fromPlace.city")
            .avg("fossil.weight").`as`("average_weight")
            .sum("fossil.weight").`as`("total_weight")
    }

    override fun getProjectOperation(): ProjectionOperation {
        return project()
            .andExpression("_id").`as`("city")
            .andExpression("average_weight").`as`("average_weight_delivered_from")
            .andExpression("total_weight").`as`("total_weight_delivered_from")
            .andExpression("_id").`as`("city")
            .andExclude("_id")
    }
}