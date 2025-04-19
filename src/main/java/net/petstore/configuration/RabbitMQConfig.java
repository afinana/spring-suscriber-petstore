package net.petstore.configuration;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String PET_EXCHANGE_NAME = "petstore-exchange";
    public static final String USER_EXCHANGE_NAME = "user-exchange";

    public static final String PET_ADD_QUEUE = "petstore-pets-add-queue";
    public static final String PET_DELETE_QUEUE = "petstore-pets-delete-queue";

    // Users queues
    public static final String USER_ADD_QUEUE = "petstore-users-add-queue";
    public static final String USER_DELETE_QUEUE = "petstore-users-delete-queue";

    // PET configuration

    @Bean
    public TopicExchange petExchange() {
        return new TopicExchange(PET_EXCHANGE_NAME);
    }

    @Bean
    public Queue addPetQueue() {
        return new Queue(PET_ADD_QUEUE, true);
    }

    @Bean
    public Queue deletePetQueue() {
        return new Queue(PET_DELETE_QUEUE, true);
    }

    @Bean
    public Binding addPetBinding(Queue addPetQueue, TopicExchange petExchange) {
        return BindingBuilder.bind(addPetQueue).to(petExchange).with("pets-add.key");
    }

    @Bean
    public Binding deletePetBinding(Queue deletePetQueue, TopicExchange petExchange) {
        return BindingBuilder.bind(deletePetQueue).to(petExchange).with("pets-delete.key");
    }

    // USER configuration

    @Bean
    public TopicExchange userExchange() {
        return new TopicExchange(USER_EXCHANGE_NAME);
    }

    @Bean
    public Queue addUserQueue() {
        return new Queue(USER_ADD_QUEUE, true);
    }

    @Bean
    public Queue deleteUserQueue() {
        return new Queue(USER_DELETE_QUEUE, true);
    }


    @Bean
    public Binding addUserBinding(Queue addUserQueue, TopicExchange userExchange) {
        return BindingBuilder.bind(addUserQueue).to(userExchange).with("users-add.key");
    }
    @Bean
    public Binding deleteUserBinding(Queue deleteUserQueue, TopicExchange userExchange) {
        return BindingBuilder.bind(deleteUserQueue).to(userExchange).with("users-delete.key");
    }
}
