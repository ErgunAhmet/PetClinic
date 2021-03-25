package be.ahmetergun.petclinic.repositories;

import be.ahmetergun.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
