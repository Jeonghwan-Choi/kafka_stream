package com.kafka.stream.controller;

import com.kafka.stream.service.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    private static final Logger logger = LoggerFactory.getLogger(KafkaController.class);

    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping("/send")
    public String sendMessage(@RequestParam("message") String message) {
//        logger.info("Received API request to send message: {}", message);
        kafkaProducer.sendMessage(message);
        return "Message sent to Kafka topic successfully";
    }
}