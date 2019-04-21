package com.example.kafka.controller

import com.example.kafka.domainobject.CustomMessage
import com.example.kafka.service.ProducerService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/messages")
class MessageController (
        private val producerService: ProducerService
){

    @PostMapping
    fun pushMessage(@RequestBody message: CustomMessage){
        producerService.produce(message.toString())
    }
}