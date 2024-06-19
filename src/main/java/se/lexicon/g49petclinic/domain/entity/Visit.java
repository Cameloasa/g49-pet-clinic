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
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String description;


    private LocalDate visitDate;

    @ManyToMany(mappedBy = "visits")
    private List<Pet> pets = new ArrayList<>();


    public Visit(String description) {
        this.description = description;
        this.visitDate = LocalDate.now();
    }


    
}
