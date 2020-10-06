package starter.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import org.hamcrest.Matchers;
import starter.ui.ShopPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static starter.ui.ShopPage.CATEGORIES;
import static starter.ui.ShopPage.ITEMS;

public class ShopPageSteps {
   ShopPage shopPage = new ShopPage();

    @When("^he looks at the shop page$")
    public void goToShopPage() {
        shopPage.open();
    }
    @Then("there are {int} items available per category")
    public void thereAreNItemsAvailablePerCategory(int numberOfItems) {
        ListOfWebElementFacades listOfCategories = shopPage.$$(CATEGORIES);
        assertThat(listOfCategories.size(), Matchers.greaterThan(0));
        listOfCategories.forEach(category->assertThat("There should be "+numberOfItems +" items per category",
                    category.thenFindAll(ITEMS).size(), is(numberOfItems)));}

    }

