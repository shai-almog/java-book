package com.debugagent.messagequeue.conf;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    public static final String TOPIC_EXCHANGE_NAME = "example-topic-exchange";
    public static final String QUEUE_NAME_1 = "example-queue-1";

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE_NAME);
    }

    @Bean
    public Queue queue1() {
        return new Queue(QUEUE_NAME_1, false);
    }

    @Bean
    public Binding binding1(TopicExchange topicExchange, Queue queue1) {
        return BindingBuilder.bind(queue1).to(topicExchange).with("example.routingkey.1");
    }
}

