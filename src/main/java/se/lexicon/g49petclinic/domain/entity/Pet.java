package se.lexicon.g49petclinic.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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



}
