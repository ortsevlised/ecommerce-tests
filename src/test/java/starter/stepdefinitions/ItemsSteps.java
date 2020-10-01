package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.Actor;
import starter.actions.AddItem;

import java.io.IOException;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static starter.actions.ShoppingCartQuestions.theNumberOfItemsInShoppingCart;

public class ItemsSteps {

    @Given("(s)he adds an item to the cart")
    public void addItemToCart() throws IOException {
        Actor actor = theActorInTheSpotlight();
        actor.remember("CART_COUNTER", theNumberOfItemsInShoppingCart());
        actor.attemptsTo(AddItem.randomlySelected());
    }


}
