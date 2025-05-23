//package com.example.m1.kafka;
//
//import org.apache.kafka.clients.admin.NewTopic;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class KafkaConfig {
//
//    @Value("${kafka.topic.name}")
//    private String topicName;
//
//    // Create a Kafka topic with a specific name
//    @Bean
//    public NewTopic createTopic() {
//        return new NewTopic(topicName, 1, (short) 1); // Topic name, partitions, replication factor
//    }
//
//}
