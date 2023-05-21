package ru.vitnine.aggregationservice.model

import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import ru.vitnine.aggregationservice.grouping.GroupingType

data class FilterPageRequest<T>(
    val page: Int = 0,
    val size: Int = 20,
    val sortType: Sort = Sort.unsorted(),
    val groupingType: GroupingType?,
    val filter: T,
) : PageRequest(page, size, sortType)