package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import starter.actions.Login;
import starter.actions.NavigateTo;

public class LoginSteps {
    @Before
    public void before(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{actor} is an email registered user")
    public void issAnEmailRegisteredUser(Actor actor) {
        actor.wasAbleTo(
                NavigateTo.theSignInPage(),
                Login.withEmail()
        );
    }
}
