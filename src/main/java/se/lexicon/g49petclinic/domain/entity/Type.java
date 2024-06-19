package se.lexicon.g49petclinic.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

@Entity
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PetTypeEnum name;

    @OneToMany(mappedBy = "type", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Pet> pets = new ArrayList<>();



    public Type(PetTypeEnum  name) {
        this.name = name;
    }

    public void addPet(Pet pet) {
        pets.add(pet);
        pet.setType(this);
    }

    public void removePet(Pet pet) {
        pets.remove(pet);
        pet.setType(null);
    }
}
