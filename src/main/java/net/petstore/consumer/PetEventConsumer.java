package net.petstore.consumer;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.petstore.model.Pet;
import net.petstore.service.PetService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class PetEventConsumer {

    @Autowired
    private PetService petService;
    private final ObjectMapper objectMapper;

    @RabbitListener(queues = "petstore-pets-add-queue")
    public void handleAddPet(String petJson) {
        try {
            Pet pet = objectMapper.readValue(petJson, Pet.class);
            petService.addPet(pet); // Assumes Pet is a JPA entity or mapped appropriately
            log.info("Consumed and saved pet: {}", pet);
        } catch (Exception e) {
            log.error("Failed to consume addPet message", e);
        }
    }

    @RabbitListener(queues = "petstore-pets-delete-queue")
    public void handleDeletePet(Long petId) {
        try {
            petService.deletePet(petId);
            log.info("Consumed and deleted pet with ID: {}", petId);
        } catch (Exception e) {
            log.error("Failed to consume deletePet message", e);
        }
    }
}
