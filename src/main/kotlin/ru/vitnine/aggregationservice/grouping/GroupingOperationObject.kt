package ru.vitnine.aggregationservice.grouping

import org.springframework.data.mongodb.core.aggregation.GroupOperation
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation

interface GroupingOperationObject {

    fun getGroupingType(): GroupingType

    fun getGroupOperation(): GroupOperation

    fun getProjectOperation(): ProjectionOperation
}