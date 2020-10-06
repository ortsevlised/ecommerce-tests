package starter.actions;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import starter.ui.ShopPage;
import starter.ui.SignIn;

public class NavigateTo {
    public static Performable theHomePage() {
        return Task.where("{0} opens the ecommerce home page",
                Open.browserOn().the(ShopPage.class));
    }

    public static Performable theSignInPage() {
        return Task.where("{0} opens the ecommerce home page",
                Open.browserOn().the(SignIn.class));
    }

}
