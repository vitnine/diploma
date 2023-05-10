package ru.vitnine.aggregationservice.service

import org.springframework.messaging.Message

interface KafkaSender {
    fun send(message: Message<Any>)
}