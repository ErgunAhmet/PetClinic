package be.ahmetergun.petclinic.services.map;

import be.ahmetergun.petclinic.model.Speciality;
import be.ahmetergun.petclinic.services.SpecialitiesService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialitiesService {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Speciality save(Speciality object) {
        return super.save(object);
    }

    @Override
    public void delete(Speciality object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
