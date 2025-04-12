package net.petstore.service;

import net.petstore.model.ModelApiResponse;
import net.petstore.model.Pet;


public interface PetService {
    
    void addPet(Pet body);

    void deletePet(Long petId);
   
    void updatePet(Pet body);

    void updatePetWithForm(Long petId,
                           String name,
                           String status);

    ModelApiResponse uploadFile(Long petId, String additionalMetadata, String content);
}

