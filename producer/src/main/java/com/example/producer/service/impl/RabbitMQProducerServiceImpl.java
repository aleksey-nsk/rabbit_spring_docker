package com.example.producer.service.impl;

import com.example.producer.service.RabbitMQProducerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Log4j2
public class RabbitMQProducerServiceImpl implements RabbitMQProducerService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(String message, String routingKey) {
        String msg = message + " " + LocalDateTime.now();
        log.debug("Send message '" + msg + "', with routingKey '" + routingKey + "'");
        rabbitTemplate.convertAndSend("testExchange", routingKey, msg);
    }
}
