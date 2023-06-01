package ru.vitnine.aggregationservice.model.request

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import ru.vitnine.aggregationservice.grouping.GroupingType
import ru.vitnine.aggregationservice.model.CargoFilter
import ru.vitnine.aggregationservice.model.FilterPageRequest

@JsonNaming(SnakeCaseStrategy::class)
data class CargoFilterRequest(
    val city: String? = null,
    val minWeight: Int? = null,
    val maxWeight: Int? = null,
    val name: String? = null,
    val groupingType: GroupingType? = null
): PageableFilter() {
    fun toCargoFilter(): FilterPageRequest<CargoFilter> {
        return FilterPageRequest(
            page = this.page,
            size = this.size,
            groupingType = groupingType,
            filter = CargoFilter(
                city = city,
                minWeight = minWeight,
                maxWeight = maxWeight,
                name = name,
            )
        )
    }
}