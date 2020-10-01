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
import static starter.ui.Cart.CART_COUNTER;

public class CartSteps {

    @Then("the cart counter is updated with the extra item(s)")
    public void cartIsUpdated() {
        theActorInTheSpotlight().should(seeThat(theNumberOfItemsInShoppingCart(), is(getCartCounterBeforeTheUpdate()+1)));
    }

    @Then("the cart counter updates with the decrement")
    public void cartIsUpdatedForRemoval() {
        theActorInTheSpotlight().should(seeThat(theNumberOfItemsInShoppingCart(), is(getCartCounterBeforeTheUpdate()-1)));
    }

    @And("(s)he has items in his shopping cart")
    public void thereAreItemsInShoppingCart() throws IOException {
        Actor theCustomer = theActorInTheSpotlight();
        theCustomer.attemptsTo(
                Check.whether(theNumberOfItemsInShoppingCart(), is(0)).andIfSo(AddItem.randomlySelected()));
        theCustomer.remember(CART_COUNTER, theNumberOfItemsInShoppingCart());
    }

    @When("(s)he removes an item from the the cart")
    public void heRemovesAnItemFromTheTheCart() {
        Actor theCustomer = theActorInTheSpotlight();

        Object lastItemAdded = theCustomer.recall("LAST_ITEM_ADDED");
        theCustomer.attemptsTo(
                Check.whether(lastItemAdded==null)
                        .andIfSo(RemoveItem.firstInList())
                        .otherwise(RemoveItem.called(String.valueOf(lastItemAdded))));
    }

    private int getCartCounterBeforeTheUpdate() {
        return theActorInTheSpotlight().recall("CART_COUNTER");
    }
}
