package com.sofkau.questions;

import com.sofkau.models.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ReturnRegisterSuccessfulJsonResponse implements Question<Response> {
    @Override
    public Response answeredBy(Actor actor) {

        return SerenityRest.lastResponse().as(Response.class);
    }

    public static ReturnRegisterSuccessfulJsonResponse returnRegisterSuccessfulJsonResponse(){
        return new ReturnRegisterSuccessfulJsonResponse();
    }
}
