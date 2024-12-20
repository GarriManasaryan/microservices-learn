package com.example.m1.kafka;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    @Value("${kafka.topic.name}")
    private String topicName;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostConstruct
    public void init(){
        System.out.println("\n");
        System.out.println("TOPIC NAME updated");
        System.out.println(topicName);
        System.out.println("\n");
    }

    public void sendMessage(String message) {
        kafkaTemplate.send(topicName, message);
        System.out.println("Produced message: " + message);
    }

}
