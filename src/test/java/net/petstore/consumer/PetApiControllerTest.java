//package net.petstore.consumer;
//
//import net.petstore.model.ModelApiResponse;
//import net.petstore.model.Pet;
//import net.petstore.service.PetService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class PetApiControllerTest {
//
//    @Mock
//    private PetService petService;
//
//    private PetConsumer petConsumer;
//
//    @BeforeEach
//    public void setUp() {
//        petConsumer = new PetConsumer(null, null);
//        petConsumer.petService = petService;
//    }
//
//    @Test
//    public void testAddPet() {
//        Pet pet = new Pet();
//        petConsumer.addPet(pet);
//        verify(petService).addPet(pet);
//    }
//
//    @Test
//    public void testDeletePet() {
//        Long petId = 123L;
//        petConsumer.deletePet(petId, null);
//        verify(petService).deletePet(petId);
//    }
//
//    @Test
//    public void testGetPetById_Found() {
//        Long petId = 123L;
//        Pet pet = new Pet();
//        when(petService.getPetById(petId)).thenReturn(pet);
//
//        ResponseEntity<Pet> response = petConsumer.getPetById(petId);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(pet, response.getBody());
//    }
//
//    @Test
//    public void testGetPetById_NotFound() {
//        Long petId = 123L;
//        when(petService.getPetById(petId)).thenReturn(null);
//
//        ResponseEntity<Pet> response = petConsumer.getPetById(petId);
//
//        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
//    }
//
//    @Test
//    public void testUpdatePet() {
//        Pet pet = new Pet();
//        petConsumer.updatePet(pet);
//        verify(petService).updatePet(pet);
//    }
//
//    @Test
//    public void testFindPetsByStatus() {
//        List<String> status = new ArrayList<>();
//        status.add("available");
//        petConsumer.findPetsByStatus(status);
//        verify(petService).findPetsByStatus(status);
//    }
//
//    @Test
//    public void testFindPetsByTags() {
//        List<String> tags = new ArrayList<>();
//        tags.add("tag1");
//        petConsumer.findPetsByTags(tags);
//        verify(petService).findPetsByTags(tags);
//    }
//
//    @Test
//    public void testUpdatePetWithForm_NotImplemented() {
//        Long petId = 123L;
//        String name = "new name";
//        String status = "sold";
//
//        ResponseEntity<Void> response = petConsumer.updatePetWithForm(petId, name, status);
//
//        assertEquals(HttpStatus.NOT_IMPLEMENTED, response.getStatusCode());
//    }
//
//    @Test
//    public void testUploadFile_NotImplemented() {
//        Long petId = 123L;
//        String additionalMetadata = "some data";
//        MultipartFile file = null;
//        petConsumer.uploadFile(petId, additionalMetadata, file);
//
//    }
//}