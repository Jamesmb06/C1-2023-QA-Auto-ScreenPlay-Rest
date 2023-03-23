package com.sofkau.stepdefinitons;

import com.sofkau.setup.ApiSetUp;
import com.sofkau.tasks.DoPostJsonPlaceholder;
import com.sofkau.utils.JsonPlaceholderResources;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.apache.http.HttpStatus;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class JsonPlaceholderStepDefinitions extends ApiSetUp {
    private Post post = new Post();

    @Given("the user is on the create post page")
    public void theUserIsOnTheCreatePostPage() {
        setUp(JsonPlaceholderResources.JSON_PLACEHOLDER_BASE_URL.getValue());
    }

    @When("the user creates a new post with title {string} and body {string}")
    public void theUserCreatesANewPostWithTitleAndBody(String title, String body) {
        post.setTitle(title);
        post.setBody(body);

        actor.attemptsTo(
                DoPostJsonPlaceholder.instance()
                        .withTheResource(JsonPlaceholderResources.POSTS_RESOURCE.getValue())
                        .andTheRequestBody(post)
        );

        System.out.println(SerenityRest.lastResponse().body().asString());
    }

    @Then("the post should be created with status code {int}")
    public void thePostShouldBeCreatedWithStatusCode(int statusCode) {
        actor.should(
                seeThatResponse("El codigo de respuesta es: " + HttpStatus.SC_CREATED,
                        response -> response.statusCode(statusCode))
        );
    }
}
