package se.lexicon.startup;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.g49petclinic.domain.entity.Type;
import se.lexicon.g49petclinic.repository.TypeRepository;

@Component
public class PetTypeDataLoader implements CommandLineRunner {

    private final TypeRepository typeRepository;

    public PetTypeDataLoader(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        typeRepository.save(new Type("CAT"));
        typeRepository.save(new Type("DOG"));
        typeRepository.save(new Type("BIRD"));
        typeRepository.save(new Type("FISH"));
        typeRepository.save(new Type("REPTILE"));
        typeRepository.save(new Type("OTHERS"));

    }
}
