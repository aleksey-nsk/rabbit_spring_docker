package com.example.producer.service;

public interface RabbitMQProducerService {

    void sendMessage(String message, String routingKey);
}
