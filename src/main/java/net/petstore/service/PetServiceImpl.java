package net.petstore.service;


import lombok.extern.slf4j.Slf4j;
import net.petstore.model.ModelApiResponse;
import net.petstore.model.Pet;
import net.petstore.repository.CustomPetRepository;
import net.petstore.repository.PetRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PetServiceImpl implements PetService {

    @Autowired
    PetRepository petRepository;

    @Autowired
    CustomPetRepository customPetRepository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public void addPet(Pet petDTO) {

        net.petstore.domain.Pet pet = convertToEntity(petDTO);
        petRepository.save(pet);

    }

    @Override
    public void deletePet(Long petId) {
        petRepository.deleteById(petId);

    }

  

    @Override
    public void updatePet(Pet petDto) {

        net.petstore.domain.Pet pet = convertToEntity(petDto);
        petRepository.save(pet);
    }

    @Override
    public void updatePetWithForm(Long petId,
                                  String name,
                                  String status) {
        throw new java.lang.UnsupportedOperationException("Not supported yet.");

    }

    @Override
    public ModelApiResponse uploadFile(Long petId, String additionalMetadata, MultipartFile file) {
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }


    private net.petstore.domain.Pet convertToEntity(Pet petDto) {

        return modelMapper.map(petDto, net.petstore.domain.Pet.class);


    }


    private Pet convertToDTO(net.petstore.domain.Pet petEntity) {

        return modelMapper.map(petEntity, Pet.class);

    }


}
