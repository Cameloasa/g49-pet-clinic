package se.lexicon.g49petclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.g49petclinic.domain.entity.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {
}
