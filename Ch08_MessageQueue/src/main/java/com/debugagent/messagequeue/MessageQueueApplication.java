package com.debugagent.messagequeue;

import com.debugagent.messagequeue.messaging.MessagePublisher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MessageQueueApplication {
	private final MessagePublisher messagePublisher;

	public MessageQueueApplication(MessagePublisher messagePublisher) {
		this.messagePublisher = messagePublisher;
	}

	public static void main(String[] args) {
		SpringApplication.run(MessageQueueApplication.class, args);
	}


	@Bean
	public CommandLineRunner publishMessages() {
		return args -> {
			messagePublisher.publish("example.routingkey.1", "Message for Subscriber");
		};
	}
}
