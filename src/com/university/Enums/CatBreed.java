package com.university.Enums;

import com.university.Utils;

import java.util.stream.Stream;

public enum CatBreed {
    RAGDOLL("Ragdoll"),
    PERSIAN_CAT("Kot Perski"),
    BENGAL_CAT("Kot Bengalski"),
    ABYSSIAN_CAT("Kot Abisyński"),
    AMERICAN_SHORTHAIR_CAT("Kot Amerykański Krótkowłosy"),
    BIRMAN_CAT_BREED("Kot Birmański"),
    DEVON_REX_CAT_BREED("Devon Rex");

    private String polishName;

    CatBreed(String polishNameParam) {
        polishName = polishNameParam;
    }

    @Override
    public String toString() {
        return Utils.capitalize(polishName);
    }
}