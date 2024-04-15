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


}
