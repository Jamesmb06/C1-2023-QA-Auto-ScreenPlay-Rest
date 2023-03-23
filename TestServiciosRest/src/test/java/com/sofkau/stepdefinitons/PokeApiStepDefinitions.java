package com.sofkau.stepdefinitons;

import com.sofkau.models.Response;
import com.sofkau.setup.ApiSetUp;
import com.sofkau.utils.PokeApiResources;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

import static com.sofkau.questions.ReturnPokeApiResponse.returnPokeApiResponse;
import static com.sofkau.tasks.DoGet.doGet;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.notNullValue;

public class PokeApiStepDefinitions extends ApiSetUp {
    private String validToken = "valid_token_value";

    @Given("the user has a valid authentication token")
    public void theUserHasAValidAuthenticationToken() {
        // Aquí podríamos hacer un request para obtener un token valido, pero para este ejemplo asumiremos que ya lo tenemos.
    }

    @When("the user sends a GET request to <endpoint> with the {string} of the Pokemon")
    public void theUserSendsAGETRequestToEndpointWithTheNameOfThePokemon() {
        setUp(PokeApiResources.POKEAPI_BASE_URL.getValue());
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + validToken);
        actor.attemptsTo(
                doGet()
                        .withTheResource(PokeApiResources.POKEMON_RESOURCE.getValue())
                        .andTheHeaders(headers)
        );
        System.out.println(SerenityRest.lastResponse().body().asString());
    }

    @Then("the user receives a {int} response code and the {string} and {string} of the Pokemon")
    public void theUserReceivesAStatusResponseCodeAndTheTypeAndAbilityOfThePokemon(Integer statusCode, String type, String ability) {
        Response actualResponse = returnPokeApiResponse().answeredBy(actor);
        actor.should(
                seeThatResponse("El codigo de respuesta es: " + HttpStatus.SC_OK,
                        response -> response.statusCode(HttpStatus.SC_OK)),
                seeThat("Retorna informacion",
                        act -> actualResponse, notNullValue())
        );
    }
}