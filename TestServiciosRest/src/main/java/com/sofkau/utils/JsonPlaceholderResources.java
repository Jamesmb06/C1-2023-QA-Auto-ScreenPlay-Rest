package com.sofkau.utils;

public enum JsonPlaceholderResources {
    JSON_PLACEHOLDER_BASE_URL("https://jsonplaceholder.typicode.com"),
    POSTS_RESOURCE("/posts");

    private final String value;

    JsonPlaceholderResources(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
