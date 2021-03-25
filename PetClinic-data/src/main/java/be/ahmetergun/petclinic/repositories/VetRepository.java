package be.ahmetergun.petclinic.repositories;

import be.ahmetergun.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
