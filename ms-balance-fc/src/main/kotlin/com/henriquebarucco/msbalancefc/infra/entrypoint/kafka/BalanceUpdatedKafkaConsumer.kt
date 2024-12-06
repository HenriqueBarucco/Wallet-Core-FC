package com.henriquebarucco.msbalancefc.infra.entrypoint.kafka

import org.springframework.kafka.annotation.KafkaListener

class BalanceUpdatedKafkaConsumer {
    @KafkaListener(topics = ["balances"], groupId = "my-group")
    fun listener(message: String) {
        println("Received Message in group foo: $message")
    }
}
