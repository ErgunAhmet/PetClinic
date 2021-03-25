package be.ahmetergun.petclinic.services.map;

import be.ahmetergun.petclinic.model.Pet;
import be.ahmetergun.petclinic.services.CrudService;
import be.ahmetergun.petclinic.services.PetService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet object) {

        return super.save(object);

    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
