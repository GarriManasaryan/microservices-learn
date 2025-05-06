package com.example.m1.port.adapters.backoffice.resource;

import com.example.m1.kafka.KafkaProducerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

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

    @GetMapping("/api/test")
    public void postTest(){
        System.out.println("1");

        var some = new ConcurrentHashMap<>();
        some.put("key", "value");
        System.out.println(some.get("key"));

        System.out.println("2");

        var some2 = new ConcurrentSkipListMap<>();
        some2.put("key", "value");
        System.out.println(some2.get("key"));

        System.out.println("3");
    }

}
