package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.Actor;
import starter.actions.Login;
import starter.actions.NavigateTo;

public class LoginSteps {
    @Given("{actor} is an email registered user")
    public void issAnEmailRegisteredUser(Actor actor) {
        actor.wasAbleTo(
                NavigateTo.theSignInPage(),
                Login.withEmail()
        );
    }


}
