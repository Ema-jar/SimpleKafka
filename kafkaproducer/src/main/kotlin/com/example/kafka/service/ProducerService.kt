package com.example.kafka.service

import mu.KLogging
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class ProducerService (
        private val kafkaTemplate: KafkaTemplate<String, String>
) {

    companion object{
        private const val TOPIC = "users"
        val logger = KLogging().logger
    }

    fun produce(message: String){
        logger.info("Producing message {} to topic {}", message, TOPIC)
        kafkaTemplate.send(TOPIC, message)
    }
}