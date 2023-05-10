package ru.vitnine.aggregationservice.service.impl

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.messaging.Message
import org.springframework.stereotype.Service
import ru.vitnine.aggregationservice.configuration.properties.KafkaProperties
import ru.vitnine.aggregationservice.service.KafkaSender

//@Service
//class KafkaSenderImpl(
//    private val kafkaProperties: KafkaProperties,
//    private val kafkaTemplate: KafkaTemplate<String, Any>,
//) : KafkaSender {
//
//    override fun send(message: Message<Any>) {
//        if (kafkaProperties.enabled)
//            kafkaTemplate.send(message)
//    }
//}