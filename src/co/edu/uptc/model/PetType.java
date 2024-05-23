package co.edu.uptc.model;

import lombok.Getter;

@Getter
public enum PetType {
    CAT("Gato"),
    DOG("Perro");

    private final String displayName;

    PetType(String displayName) {
        this.displayName = displayName;
    }

}