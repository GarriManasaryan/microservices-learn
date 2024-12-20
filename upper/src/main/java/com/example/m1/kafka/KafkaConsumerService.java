package com.example.m1.kafka;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "quickstart-events", groupId = "my-group")
    public void consume(String message) {
        System.out.println("\n");
        System.out.println("Consumed message: " + message);
        System.out.println("\n");
    }

}
