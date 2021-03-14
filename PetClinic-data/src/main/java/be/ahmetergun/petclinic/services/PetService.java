package be.ahmetergun.petclinic.services;

import be.ahmetergun.petclinic.model.Owner;
import be.ahmetergun.petclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
