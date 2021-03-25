package be.ahmetergun.petclinic.model;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity{
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = 'pet_id')
    private PetType petType;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
    @Column(name = "birth_date")
    private LocalDate birthdate;

    public PetType getPetType() {
        return petType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}
