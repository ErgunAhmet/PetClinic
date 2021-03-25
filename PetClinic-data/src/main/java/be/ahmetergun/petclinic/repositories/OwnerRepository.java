package be.ahmetergun.petclinic.repositories;

import be.ahmetergun.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
