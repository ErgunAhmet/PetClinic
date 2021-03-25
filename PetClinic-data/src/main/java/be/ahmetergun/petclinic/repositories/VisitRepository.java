package be.ahmetergun.petclinic.repositories;

import be.ahmetergun.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
