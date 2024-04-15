package org.example.schroniskozwierzat;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;


@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface AnimalMapper {

    @Mapping( target = "id", ignore=true)
    @Mapping( target = "name", ignore=true)
    @Mapping( target = "species", ignore=true)
    @Mapping( target = "age", ignore=true)
    Animal mapToAnimal(AnimalRequest request);
    AnimalResponse roResponse(Animal animal);
    default AnimalResponse toDto(Animal entity) {
        if (entity == null) {
            return null;
        }
        AnimalResponse animalResponse = new AnimalResponse();
        animalResponse.setId(entity.getId());
        animalResponse.setName(entity.getName());
        animalResponse.setSpecies(entity.getSpecies());
        animalResponse.setAge(entity.getAge());
        return animalResponse;
    }
}
