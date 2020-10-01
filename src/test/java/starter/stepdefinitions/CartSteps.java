package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.conditions.Check;
import starter.actions.AddItem;
import starter.actions.RemoveItem;

import java.io.IOException;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.is;
import static starter.actions.ShoppingCartQuestions.theNumberOfItemsInShoppingCart;

public class CartSteps {

    private static String lastItemAdded;

    @Then("the cart counter is updated with the extra item(s)")
    public void cartIsUpdated() {
        theActorInTheSpotlight().should(seeThat(theNumberOfItemsInShoppingCart(), is(getCartCounterBeforeTheUpdate()+1)));
    }

    @Then("the cart counter updates with the decrement")
    public void cartIsUpdatedForRemoval() {
        theActorInTheSpotlight().should(seeThat(theNumberOfItemsInShoppingCart(), is(getCartCounterBeforeTheUpdate()-1)));
    }

    private int getCartCounterBeforeTheUpdate() {
        return theActorInTheSpotlight().recall("CART_COUNTER");
    }

    @And("(s)he has items in his shopping cart")
    public void thereAreItemsInShoppingCart() throws IOException {
        theActorInTheSpotlight().attemptsTo(
                Check.whether(theNumberOfItemsInShoppingCart(), is(0)).andIfSo(
                        AddItem.randomlySelected())
        );
        theActorInTheSpotlight().remember("CART_COUNTER", theNumberOfItemsInShoppingCart());
    }

    @When("(s)he removes an item from the the cart")
    public void heRemovesAnItemFromTheTheCart() {
        Actor theCustomer = theActorInTheSpotlight();

        theCustomer.attemptsTo(
                Check.whether(theCustomer.recall("LAST_ITEM_ADDED") == null)
                        .andIfSo(RemoveItem.firstInList())
                        .otherwise(RemoveItem.called(theCustomer.recall("LAST_ITEM_ADDED").toString())));
    }
}
