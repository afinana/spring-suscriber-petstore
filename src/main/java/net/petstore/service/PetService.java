package net.petstore.service;

import net.petstore.model.ModelApiResponse;
import net.petstore.model.Pet;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PetService {
    
    void addPet(Pet body);

    void deletePet(Long petId);
   
    void updatePet(Pet body);

    void updatePetWithForm(Long petId,
                           String name,
                           String status);

    ModelApiResponse uploadFile(Long petId, String additionalMetadata, MultipartFile file);
}

