package ru.vitnine.aggregationservice.configuration.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("kafka-prop")
data class KafkaProperties (
    val topic: String = "example-topic",
    val enabled: Boolean = false
)