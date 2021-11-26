package be.infernalwhale.petstore.service;

import be.infernalwhale.petstore.model.Pet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PetValidator {
    public boolean validate(Pet pet) {
        return true;
    }

    public boolean validateStatus(List<String> status) {
        return true;
    }
}
