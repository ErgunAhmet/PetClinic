package be.ahmetergun.petclinic.controllers;

import be.ahmetergun.petclinic.model.Owner;
import be.ahmetergun.petclinic.model.Pet;
import be.ahmetergun.petclinic.model.PetType;
import be.ahmetergun.petclinic.services.OwnerService;
import be.ahmetergun.petclinic.services.PetService;
import be.ahmetergun.petclinic.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Collection;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {
    private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";

    private final PetService petService;
    private final PetTypeService petTypeService;
    private final OwnerService ownerService;

    public PetController(PetService pets, PetTypeService petTypeService, OwnerService ownerService) {
        this.petService = pets;
        this.petTypeService = petTypeService;
        this.ownerService = ownerService;
    }

    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes() {
        return this.petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") Long ownerId) {
        return this.ownerService.findById(ownerId);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/pets/new")
    public String initCreationForm(Owner owner, Model model) {
        Pet pet = new Pet();
        owner.getPets().add(pet);
        pet.setOwner(owner);
        model.addAttribute("pet", pet);
        return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/pets/new")
    public String processCreationForm(Owner owner, @Valid Pet pet, BindingResult result, Model model) {
        if (StringUtils.hasLength(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null){
            result.rejectValue("name", "duplicate", "already exists");
        }
        pet.setOwner(owner);
        if (result.hasErrors()) {
            model.addAttribute("pet", pet);
            return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
        } else {
            petService.save(pet);

            return "redirect:/owners/" + owner.getId();
        }
    }
    @GetMapping("/pets/{petId}/edit")
    public String initUpdateForm(@PathVariable Long petId, Model model) {
        model.addAttribute("pet", petService.findById(petId));
        return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/pets/{petId}/edit")
    public String processUpdatePetForm(@ModelAttribute("owner") Owner owner,
                                       @Valid @ModelAttribute("pet") Pet pet,
                                       @PathVariable String petId, BindingResult bindingResult,
                                       Model model) {
// validate the input data
        if (StringUtils.hasLength(pet.getName())) {
            Pet foundPet = owner.getPet(pet.getName());
            if (foundPet!=null && !foundPet.getId().equals(Long.valueOf(petId))) {
                bindingResult.rejectValue("name", "duplicate", "already used for other pet for this owner");
            }
        }
        if (!StringUtils.hasLength(pet.getName())) {
            bindingResult.rejectValue("name", "null", "name of pet cannot be empty");
        }
        pet.setOwner(owner);
        if (bindingResult.hasErrors()) {
            model.addAttribute("pet", pet);
            return "pets/createOrUpdatePet";
        }
// update the pet information in database
// when apply the hibernate db, data store in db in sql style,
// all the java model only created after apply CrudRepository to retrieve
// data from database; or created before apply crudRepository to store data to database
// Therefore, there is no need to update the pet set in owner model.
// Instead of it, only to maintain the relationship between pet and owner in hibernate db.
        Pet foundPet = petService.findById(Long.valueOf(petId));
        foundPet.setOwner(owner);
        foundPet.setPetType(pet.getPetType());
        foundPet.setName(pet.getName());
        foundPet.setBirthDate(pet.getBirthDate());
        petService.save(foundPet);
        return "redirect:/owners/" + owner.getId();
    }
}
