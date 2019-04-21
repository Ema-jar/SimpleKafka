package com.example.kafka.service

import mu.KLogging
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class ConsumerService {

    companion object{
        private const val TOPIC = "users"
        val logger = KLogging().logger
    }

    @KafkaListener(topics = [TOPIC], groupId = "group_id")
    fun consume(message: String){
        logger.info("Consuming message {}", message)
    }

}