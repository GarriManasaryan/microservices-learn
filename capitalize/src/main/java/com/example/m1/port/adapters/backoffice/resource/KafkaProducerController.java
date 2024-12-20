package com.example.m1.port.adapters.backoffice.resource;

import com.example.m1.kafka.KafkaProducerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducerController {

    public record KafkaEventRequestBody(String message){}

    private final KafkaProducerService kafkaProducerService;

    public KafkaProducerController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping("/api/produce")
    public void postEvent(@RequestBody KafkaEventRequestBody kafkaEventRequestBody){
        kafkaProducerService.sendMessage(kafkaEventRequestBody.message);
    }

}
