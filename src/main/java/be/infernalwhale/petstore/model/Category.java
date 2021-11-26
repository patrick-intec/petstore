package be.infernalwhale.petstore.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Accessors(chain = true) // Optional.. but I like it...
public class Category {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
