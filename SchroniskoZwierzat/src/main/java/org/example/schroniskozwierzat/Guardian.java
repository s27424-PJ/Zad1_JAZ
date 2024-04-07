package org.example.schroniskozwierzat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Data
@Entity
public class Guardian {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;

    @ManyToMany
    private List<Animal> animals;
}
