package ru.vitnine.aggregationservice.grouping

import org.springframework.data.mongodb.core.aggregation.Aggregation
import org.springframework.data.mongodb.core.aggregation.Aggregation.project
import org.springframework.data.mongodb.core.aggregation.GroupOperation
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation
import org.springframework.stereotype.Component

@Component
class ToCityGrouping: GroupingOperation {

    override fun getGroupingType(): GroupingType {
        return GroupingType.TO_CITY
    }

    override fun getGroupOperation(): GroupOperation {
        return Aggregation.group("toPlace.city")
            .avg("fossil.weight").`as`("average_weight")
            .sum("fossil.weight").`as`("total_weight")
    }

    override fun getProjectOperation(): ProjectionOperation {
        return project()
            .andExpression("_id").`as`("to_city")
            .andExpression("average_weight").`as`("average_weight_delivered_to")
            .andExpression("total_weight").`as`("total_weight_delivered_to")
            .andExclude("_id")
    }
}