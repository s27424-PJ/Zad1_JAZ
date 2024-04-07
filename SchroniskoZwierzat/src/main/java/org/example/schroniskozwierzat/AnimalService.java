package org.example.schroniskozwierzat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AnimalService {
    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal getAnimalById(UUID id) {
        Optional<Animal> animalOptional = animalRepository.findById(id);
        return animalOptional.orElse(null);
    }

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public Animal saveAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public void deleteAnimal(UUID id) {
        animalRepository.deleteById(id);
    }
}
