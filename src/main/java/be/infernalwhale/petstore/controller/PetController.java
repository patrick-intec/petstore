package be.infernalwhale.petstore.controller;

import be.infernalwhale.petstore.model.Pet;
import be.infernalwhale.petstore.service.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pet")
public class PetController {
    private final PetService service;

    public PetController(PetService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity createPet(@RequestBody Pet pet) {
        Optional<Pet> optionalPet = service.save(pet);

        if (optionalPet.isEmpty()) return ResponseEntity.status(405).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(optionalPet.get().getId());
    }


    // http://host/pet/findByStatus?status=sold,available,pending
    @GetMapping("/findByStatus")
    public ResponseEntity findByStatus(@RequestParam("status") List<String> status) {
        Optional<List<Pet>> resp = service.findByStatus(status);

        if (resp.isEmpty()) return ResponseEntity.badRequest().body("Invalid status");
        return ResponseEntity.ok(resp.get());
    }
}
