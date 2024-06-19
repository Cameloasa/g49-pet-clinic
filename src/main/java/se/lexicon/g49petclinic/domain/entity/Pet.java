package se.lexicon.g49petclinic.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @Column(nullable = false)
    private String name;


    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @Setter
    private Owner owner;

    @ManyToMany
    @JoinTable(
            name = "pets_visits",
            joinColumns = @JoinColumn(name = "pet_id"),
            inverseJoinColumns = @JoinColumn(name = "visit_id")
    )
    private List<Visit> visits;

    public Pet(String name, LocalDate birthDate, Type type, Owner owner) {
        this.name = name;
        this.birthDate = birthDate;
        this.type = type;
        this.owner = owner;
    }

    public void addVisit(Visit visit) {
       visits.add(visit);
       visit.getPets().add(this);
    }
    public void removeVisit(Visit visit) {
        visits.remove(visit);
        visit.getPets().remove(this);

    }
}
