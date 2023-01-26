package com.example.consumer.component;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit // нужна для активации обработки аннотаций @RabbitListener
@Log4j2
public class RabbitMQConsumer {

    // Листенер
    @RabbitListener(queues = "queue1")
    public void processMyQueue(String message) throws InterruptedException {
        Thread.sleep(10_000L); // эмуляция полезной работы
        log.debug("Received from Queue message: '" + new String(message.getBytes()) + "'");
    }
}
