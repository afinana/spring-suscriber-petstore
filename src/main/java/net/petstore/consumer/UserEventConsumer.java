package net.petstore.consumer;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import net.petstore.service.UserService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class UserEventConsumer {

    @Autowired
    UserService userRepository;

    ObjectMapper objectMapper;

    @RabbitListener(queues = "petstore-users-add-queue")
    public void handleAddUser(String userJson) {
        try {
            net.petstore.model.User user = objectMapper.readValue(userJson, net.petstore.model.User.class);

            userRepository.createUser(user); // Assumes Pet is a JPA entity or mapped appropriately
            log.info("Consumed and saved user: {}", userJson);
        } catch (Exception e) {
            log.error("Failed to consume addPet message", e);
        }
    }

    @RabbitListener(queues = "petstore-users-delete-queue")
    public void handleDeleteUser(Long userId) {
        try {
            userRepository.deleteUser(String.valueOf(userId));
            log.info("Consumed and deleted pet with ID: {}", userId);
        } catch (Exception e) {
            log.error("Failed to consume deletePet message", e);
        }
    }

}
