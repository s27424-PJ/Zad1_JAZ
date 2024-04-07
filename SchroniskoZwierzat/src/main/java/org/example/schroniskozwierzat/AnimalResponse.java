package org.example.schroniskozwierzat;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class AnimalResponse {
    private UUID id;
    private String name;
    private String species;
    private int age;

    public static AnimalResponse fromAnimal(Animal animal) {
        AnimalResponse response = new AnimalResponse();
        response.setId(animal.getId());
        response.setName(animal.getName());
        response.setSpecies(animal.getSpecies());
        response.setAge(animal.getAge());
        return response;
    }
}
