package be.ahmetergun.petclinic.services;

import be.ahmetergun.petclinic.model.Pet;
import be.ahmetergun.petclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);

    Vet save(Vet vet);


    Set<Vet> findAll();
}
