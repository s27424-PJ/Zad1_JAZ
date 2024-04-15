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
    private final AnimalMapper animalMapper;

    @Autowired
    public AnimalController(AnimalService animalService, AnimalMapper animalMapper) {
        this.animalService = animalService;
        this.animalMapper = animalMapper;
    }

    @GetMapping
    public List<AnimalResponse> listAnimals() {
        List<Animal> animals = animalService.getAllAnimals();
        return animals.stream()
                .map(animalMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public AnimalResponse createAnimal(@RequestBody AnimalRequest animalRequest) {
        Animal animal = animalMapper.mapToAnimal(animalRequest);
        Animal savedAnimal = animalService.saveAnimal(animal);
        return animalMapper.toDto(savedAnimal);
    }

    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable UUID id) {
        animalService.deleteAnimal(id);
    }

    @PutMapping("/{id}")
    public AnimalResponse updateAnimal(@PathVariable UUID id, @RequestBody AnimalRequest animalRequest) {
        Animal animal = animalMapper.mapToAnimal(animalRequest);
        animal.setId(id);
        Animal updatedAnimal = animalService.saveAnimal(animal);
        return animalMapper.toDto(updatedAnimal);
    }
}
