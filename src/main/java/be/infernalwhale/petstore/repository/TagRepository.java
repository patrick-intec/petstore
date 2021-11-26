package be.infernalwhale.petstore.repository;

import be.infernalwhale.petstore.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
