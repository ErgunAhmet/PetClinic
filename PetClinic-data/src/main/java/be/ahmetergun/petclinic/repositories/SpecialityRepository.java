package be.ahmetergun.petclinic.repositories;

import be.ahmetergun.petclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
