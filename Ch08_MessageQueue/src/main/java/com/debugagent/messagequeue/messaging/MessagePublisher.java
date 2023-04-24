package com.debugagent.messagequeue.messaging;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessagePublisher {

    private final RabbitTemplate rabbitTemplate;
    private final TopicExchange topicExchange;

    public MessagePublisher(RabbitTemplate rabbitTemplate, TopicExchange topicExchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.topicExchange = topicExchange;
    }

    public void publish(String routingKey, String message) {
        rabbitTemplate.convertAndSend(topicExchange.getName(), routingKey, message);
    }
}
