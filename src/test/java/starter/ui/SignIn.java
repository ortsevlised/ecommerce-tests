package starter.ui;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("/signin")

public class SignIn extends UIInteractionSteps {
     //     public static final Target LOGIN_BTN = Target.the("login button")
//             .located(By.id("login_btn"));
     public static final Target LOGIN_BTN = Target.the("login button")
             .locatedBy("//div[@class='sign-in']//button[contains(text(),'Submit Form')]");
     public static Target CART_COUNTER = Target.the("the cart counter").located(By.className("item-count"));

     public static final Target LOGIN_EMAIL_INPUT = Target.the("email input field")
             .locatedBy(".sign-in [name=email]");

     public static final Target LOGIN_PASSWORD_INPUT = Target.the("password input field")
             .locatedBy(".sign-in [name=password]");
}
