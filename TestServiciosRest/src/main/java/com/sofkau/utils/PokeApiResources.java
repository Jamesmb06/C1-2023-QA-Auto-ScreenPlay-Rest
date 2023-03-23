package com.sofkau.utils;

public enum PokeApiResources {
    POKEAPI_BASE_URL("https://pokeapi.co/api/v2/"),
    POKEMON_RESOURCE("pokemon/1");
    private final String value;

    PokeApiResources(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
