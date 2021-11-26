package be.infernalwhale.petstore.repository;

import be.infernalwhale.petstore.model.Pet;
import be.infernalwhale.petstore.model.PetStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findByStatus(PetStatus status);
}
