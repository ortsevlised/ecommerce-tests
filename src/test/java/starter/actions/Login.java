package starter.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import starter.enums.Users;
import starter.ui.SignIn;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class Login implements Task {
    private final String email;
    private final String password;

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Step("{0} Logs in via email and password")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(email).into(SignIn.LOGIN_EMAIL_INPUT),
                Enter.theValue(password).into(SignIn.LOGIN_PASSWORD_INPUT),
                Click.on(SignIn.LOGIN_BTN)

        );
    }

    public static Login withEmail() {
        Users user = Users.valueOf(theActorInTheSpotlight().getName().toUpperCase());
        return instrumented(Login.class, user.getEmail(), user.getPassword());
    }
}