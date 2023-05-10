package ru.vitnine.aggregationservice.configuration

import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory

@Configuration
class KafkaConfig {

    @Bean
    fun kafkaProducerFactory(props: KafkaProperties): ProducerFactory<String, Any> {
        return DefaultKafkaProducerFactory(props.buildProducerProperties())
    }

    @Bean
    fun kafkaTemplate(
        kafkaProducerFactory: ProducerFactory<String, Any>): KafkaTemplate<String, Any> {
        return KafkaTemplate(kafkaProducerFactory)
    }
}