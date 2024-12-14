package com.example.m2.application;

import com.example.m2.domain.Product;
import com.example.m2.port.adapters.persistence.PostgresqlProducts;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import io.micrometer.tracing.Span;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ProductService {

    private final MeterRegistry meterRegistry;
    private final Timer saveStringTimer;
    private final AtomicInteger activeRequests = new AtomicInteger(0);
    private final PostgresqlProducts postgresqlProducts;

    public ProductService(MeterRegistry meterRegistry, PostgresqlProducts postgresqlProducts) {
        this.meterRegistry = meterRegistry;
        this.saveStringTimer = Timer
                            .builder("my.timer")
                            .description("a description of what this timer does") // optional
                            .tags("region", "test") // optional
                            .register(meterRegistry);
        this.postgresqlProducts = postgresqlProducts;

        // Register a gauge to measure the number of active requests in progress
        Gauge.builder("saveString.activeRequests", activeRequests, AtomicInteger::get)
                .register(meterRegistry);

    }

    public void actualSave(String name){
        postgresqlProducts.save(name);
        // отправить запрос на другие сервера
//        sendRequest("http://backend-capitalize", name);
//        sendRequest("http://backend-upper", name);

    }


    public void save(String data) {
        activeRequests.incrementAndGet(); // Increment active request count

        // Start a new span for tracing
//        Span span = tracer.nextSpan().name("saveString").start();
//        try (Tracer.SpanInScope ws = tracer.withSpan(span)) {
        try  {

            // Timer to track the execution time of the saveString method
            saveStringTimer.record(() -> {
                // Simulate processing (this will be timed)
                actualSave(data);

                // Any additional processing logic here
                try {
                    Thread.sleep(1000); // Simulated delay
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

        } finally {
//            span.end(); // End the span
            activeRequests.decrementAndGet(); // Decrement active request count
        }
    }

    private void sendRequest(String hostname, String name){

        // отправить запрос на другие сервера

        RestTemplate restTemplate = new RestTemplate();
        // host - название сервиса, а порт - внутренний должен быть, мы же внутри контейнера
         String uri = hostname + ":8080/api/products/" + name;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(headers);

        restTemplate.exchange(uri, HttpMethod.POST, entity, Product.class);
    }

}
