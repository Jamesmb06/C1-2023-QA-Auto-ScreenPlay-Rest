package com.sofkau.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.util.Map;

public class DoGet implements Task {
    private String resource;
    private Map<String, String> headers;
    public DoGet withTheResource(String resource) {
        this.resource = resource;
        return this;
    }

    public DoGet andTheHeaders(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(resource)
                        .with(request -> request.headers(headers))
        );
    }

    public static DoGet doGet() {
        return new DoGet();
    }
}
