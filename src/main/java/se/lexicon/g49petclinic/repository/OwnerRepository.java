package se.lexicon.g49petclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.g49petclinic.domain.entity.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
