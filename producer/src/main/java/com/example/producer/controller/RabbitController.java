package com.example.producer.controller;

import com.example.producer.model.MessageModel;
import com.example.producer.service.RabbitMQProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// В качестве продюссера будет контроллер,
// который будет посылать сообщения в RabbitMQ

@RestController
public class RabbitController {

    @Autowired
    private RabbitMQProducerService rabbitMQProducerService;

    @GetMapping("/health")
    public String healthCheck() {
        return "OK";
    }

    @GetMapping("/send")
    public void sendMessageToRabbit(@RequestBody MessageModel messageModel) {
        rabbitMQProducerService.sendMessage(messageModel.getMessage(), messageModel.getRoutingKey());
    }
}
