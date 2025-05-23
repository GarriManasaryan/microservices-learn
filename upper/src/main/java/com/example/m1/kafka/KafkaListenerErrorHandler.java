package com.example.m1.kafka;

import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;

@FunctionalInterface
public interface KafkaListenerErrorHandler {

    Object handleError(Message<?> message, ListenerExecutionFailedException exception) throws Exception;

}
