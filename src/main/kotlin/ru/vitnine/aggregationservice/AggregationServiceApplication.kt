package ru.vitnine.aggregationservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
class AggregationServiceApplication

fun main(args: Array<String>) {
    runApplication<AggregationServiceApplication>(*args)
}
