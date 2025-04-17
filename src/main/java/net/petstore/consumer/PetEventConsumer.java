package net.petstore.consumer;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import net.petstore.model.Pet;
import net.petstore.service.PetService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PetEventConsumer {


    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private PetService service;

    @KafkaListener(topics = "pet-topic", groupId = "pet-group")
    public void consumePetEvent(ConsumerRecord<String, String> record) {
        String key = record.key();
        String value = record.value();
        log.info("Received message from Kafka:{ key:{}, value:{} }", key, value);

        try {
            switch (key) {
                case "CREATE":
                    Pet createdPet = objectMapper.readValue(value, Pet.class);
                    handleCreate(createdPet);
                    break;
                case "UPDATE":
                    Pet updatedPet = objectMapper.readValue(value, Pet.class);
                    handleUpdate(updatedPet);
                    break;
                case "DELETE":
                    Long deletedPetId = Long.parseLong(value);
                    handleDelete(deletedPetId);
                    break;
                default:
                    log.warn("Unknown key: " + key);
            }
        } catch (Exception e) {
            log.error("Error processing pet event: " + e.getMessage());
        }
    }

    private void handleCreate(Pet pet) {
        // Logic to handle pet creation
        log.info("Handling CREATE for pet: " + pet);
        service.addPet(pet);
    }

    private void handleUpdate(Pet pet) {
        // Logic to handle pet update
        log.info("Handling UPDATE for pet: {}", pet);
        service.updatePet(pet);
    }

    private void handleDelete(Long petId) {
        // Logic to handle pet deletion
        log.info("Handling DELETE for pet ID: {}", petId);
        service.deletePet(petId);
    }
}

