package be.infernalwhale.petstore.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Pet {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToOne
    private Category category;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> photoUrls;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Tag> tags;

    @Enumerated(EnumType.STRING)
    private PetStatus status;
}
