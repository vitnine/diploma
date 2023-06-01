package ru.vitnine.aggregationservice.model.request

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import ru.vitnine.aggregationservice.grouping.GroupingType
import ru.vitnine.aggregationservice.model.CargoFilter
import ru.vitnine.aggregationservice.model.FilterPageRequest

@JsonNaming(SnakeCaseStrategy::class)
data class CargoFilterRequest(
    val fromCity: String? = null,
    val toCity: String? = null,
    val minWeight: Int? = null,
    val maxWeight: Int? = null,
    val fossilName: String? = null,
    val groupingType: GroupingType? = null
): PageableFilter() {
    fun toCargoFilter(): FilterPageRequest<CargoFilter> {
        return FilterPageRequest(
            page = this.page,
            size = this.size,
            groupingType = groupingType,
            filter = CargoFilter(
                fromCity = fromCity,
                toCity = toCity,
                minWeight = minWeight,
                maxWeight = maxWeight,
                name = fossilName,
            )
        )
    }
}