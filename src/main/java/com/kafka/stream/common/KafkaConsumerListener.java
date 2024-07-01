package com.kafka.stream.common;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerListener {

    @KafkaListener(topics = "kafka_topic", groupId = "kafka-gid")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}