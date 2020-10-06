package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.util.EnvironmentVariables;
import starter.ValidateResponse;

import java.util.ArrayList;
import java.util.List;

public class ApiSteps {
    public static final String IRELAND_COORDINATES = "lat=53.14247&lon=7.6921";
    private String theApiBaseUrl;
    private EnvironmentVariables environmentVariables;
    private final List<Header> authorisedHeader = new ArrayList<>();
    private String theApiKey;

    @Before
    public void configureBaseUrl() {
        theApiBaseUrl = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("apiBaseUrl");
        theApiKey = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("apiKey");

    }

    @Given("I search for the temperature in ireland in {word} format")
    public void iSearchForTheNStarWarsFilms(String format) {
        authorisedHeader.add(new Header("apikey", theApiKey));
        SerenityRest.given().headers(new Headers(authorisedHeader))
                .get(theApiBaseUrl + "realtime?" + IRELAND_COORDINATES + "&unit_system=" + format.toLowerCase() + "&fields=temp");
    }

    @Then("I get a response where {string}")
    public void iGetAResponseWhereResponse(String expectedResponse) {
        SerenityRest.restAssuredThat(response -> {
            response.statusCode(200).log().everything();
            ValidateResponse.validateFieldValues(expectedResponse, response.extract().body().jsonPath());
        });
    }

    @Given("the weather app is running")
    public void theWeatherAppIsRunning() {
//todo find the status endpoint
    }
}
