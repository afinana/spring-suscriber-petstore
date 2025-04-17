package net.petstore.consumer;


import lombok.extern.slf4j.Slf4j;
import net.petstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

@Slf4j
public class UserEventConsumer {


    @Autowired
    UserService userService;

    @KafkaListener(topics = "user-topic", groupId = "user-consumer-group")
    public void consume(String message) {
        try {
            log.info("Received message from Kafka: {}", message);
            // Process the message (e.g., deserialize JSON, handle events)
        } catch (Exception e) {
            log.error("Failed to process Kafka message", e);
        }
    }

}
