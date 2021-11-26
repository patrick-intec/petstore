package be.infernalwhale.petstore.service;

import be.infernalwhale.petstore.model.Pet;
import be.infernalwhale.petstore.model.PetStatus;
import be.infernalwhale.petstore.repository.PetRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PetService {
    private final PetRepository repository;
    private final PetValidator validator;
    private final ApplicationEventPublisher publisher;

    public PetService(PetRepository repository, PetValidator validator, ApplicationEventPublisher publisher) {
        this.repository = repository;
        this.validator = validator;
        this.publisher = publisher;
    }

    public Optional<Pet> save(Pet pet) {
        // Write to log: Request to save new pet received
        if (validator.validate(pet)) {
            // Write to log: New pet passed validation
            publisher.publishEvent("New pet about to be saved to database...");
            return Optional.of(repository.save(pet));
        }

        publisher.publishEvent("New pet not accepted to be written to database");

        return Optional.empty();
    }

    public Optional<List<Pet>> findByStatus(List<String> status) {
        if (!validator.validateStatus(status)) return Optional.empty();

        return Optional.of(status.stream()
                .map(s -> repository.findByStatus(PetStatus.valueOf(s)))
                .flatMap(Collection::stream)
                .collect(Collectors.toList()));
    }
}
