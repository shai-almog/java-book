package com.debugagent.messagequeue.messaging;

import com.debugagent.messagequeue.conf.RabbitMqConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageSubscriber {

    @RabbitListener(queues = RabbitMqConfig.QUEUE_NAME_1)
    public void handleMessage(String message) {
        System.out.println("Subscriber received message: " + message);
    }
}