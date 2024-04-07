package org.example.schroniskozwierzat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/animals")
public class AnimalController {
    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping
    public List<AnimalResponse> listAnimals() {
        List<Animal> animals = animalService.getAllAnimals();
        return animals.stream()
                .map(AnimalResponse::fromAnimal)
                .collect(Collectors.toList());
    }

    @PostMapping
    public AnimalResponse createAnimal(@RequestBody AnimalRequest animalRequest) {
        Animal animal = new Animal();
        animal.setName(animalRequest.getName());
        animal.setSpecies(animalRequest.getSpecies());
        animal.setAge(animalRequest.getAge());
        Animal savedAnimal = animalService.saveAnimal(animal);
        return AnimalResponse.fromAnimal(savedAnimal);
    }

    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable UUID id) {
        animalService.deleteAnimal(id);
    }

    @PutMapping("/{id}")
    public AnimalResponse updateAnimal(@PathVariable UUID id, @RequestBody AnimalRequest animalRequest) {
        Animal animal = animalService.getAnimalById(id);
        if (animal != null) {
            animal.setName(animalRequest.getName());
            animal.setSpecies(animalRequest.getSpecies());
            animal.setAge(animalRequest.getAge());
            Animal updatedAnimal = animalService.saveAnimal(animal);
            return AnimalResponse.fromAnimal(updatedAnimal);
        } else {
            throw new RuntimeException("Animal not found with id: " + id);
        }
    }
}
