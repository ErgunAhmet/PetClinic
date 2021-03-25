package be.ahmetergun.petclinic.repositories;

import be.ahmetergun.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
