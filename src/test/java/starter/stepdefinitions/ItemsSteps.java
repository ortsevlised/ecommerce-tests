package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.Actor;
import starter.actions.AddItem;

import java.io.IOException;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static starter.actions.ShoppingCartQuestions.theNumberOfItemsInShoppingCart;
import static starter.ui.Cart.CART_COUNTER;

public class ItemsSteps {

    @Given("(s)he adds an item to the cart")
    public void addItemToCart() throws IOException {
        Actor theCustomer = theActorInTheSpotlight();
        theCustomer.remember(CART_COUNTER, theNumberOfItemsInShoppingCart());
        theCustomer.attemptsTo(AddItem.randomlySelected());
    }
}
