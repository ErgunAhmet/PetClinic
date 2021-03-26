package be.ahmetergun.petclinic.services.map;

import be.ahmetergun.petclinic.model.Visit;
import be.ahmetergun.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
@Profile({"default", "map"})
public class VisitMapService extends AbstractMapService<Visit,Long> implements VisitService {
    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit object) {
        if (object.getPet() == null
                || object.getPet().getOwner() == null
                || object.getPet().getId() == null
                || object.getPet().getOwner().getId() == null){
            throw new RuntimeException("invalid Visit");
        }
        return super.save(object);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);

    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
