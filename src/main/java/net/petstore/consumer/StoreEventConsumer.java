package net.petstore.consumer;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Slf4j
public class StoreEventConsumer {

    @RabbitListener(queues = "petstore-store-add-queue")
    public void consume(String message) {
        try {
            log.info("Received message from Kafka: {}", message);
            // Process the message (e.g., deserialize JSON, handle events)
        } catch (Exception e) {
            log.error("Failed to process Kafka message", e);
        }
    }


}
