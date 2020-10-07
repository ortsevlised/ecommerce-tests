package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.ensure.web.ElementLocated;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.actions.FillForm;
import starter.actions.NavigateTo;
import starter.actions.WaithForLoading;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.waits.WaitUntil.the;
import static starter.ui.ScheduleForm.*;

public class ScheduleSteps {


    @Before
    public void before() {
        OnStage.setTheStage(new OnlineCast());
    }


    @Given("the user fills up the form with valid data")
    public void theUserFillsUpTheFormWithValidData() {//hardcoded data that could be passed from the scenario as outline examples
        theActorInTheSpotlight().attemptsTo(
                FillForm.withName("Jorge")
                        .withSurname("Desilvestro")
                        .withEmail("jdesilvestro@gmail.com")
                        .withCompany("asdas")
                        .withPhone("123123")
                        .andRegion("Europe"));
    }

    @When("(s)he submits the form")
    public void submitsForm() {
        theActorInTheSpotlight().attemptsTo(Click.on(SUBMIT_BTN).then(WaithForLoading.toFinish()));
    }

    @Then("a pop up with free slots appears")
    public void aPopUpWithTheFeeSlotsAppear() {
        theActorInTheSpotlight().attemptsTo(
                Switch.toFrame(CHILIPIPER_FRAME.resolveFor(theActorInTheSpotlight())).then(
                        Ensure.that(SCHEDULE_FORM).isDisplayed()
                ));
    }

    @Given("the user is on the form page")
    public void theUserIsOnTheFormPage() {
        OnStage.aNewActor().wasAbleTo(NavigateTo.formPage());
    }
}
