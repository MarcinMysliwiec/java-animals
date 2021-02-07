package com.university.Enums;

import com.university.Utils;

public enum DogBreed {
    CAVALIER_KING_CHARLES_SPANIEL("Cavalier King Charles Spaniel"),
    AUSTRALIAN_SHEPARD("Owczarek Australijski"),
    AMERICAN_BULLDOG("Buldog Amerykański"),
    GOLDEN_RETRIEVER("Golden Retriever"),
    DACHSHUND("Jamnik");

    private String polishName;

    DogBreed(String polishNameParam) {
        polishName = polishNameParam;
    }

    @Override
    public String toString() {
        return Utils.capitalize(polishName);
    }
}