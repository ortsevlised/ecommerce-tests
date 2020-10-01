package starter.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/")
public class HomePage extends UIInteractionSteps {
    public static final Target HATS_CATEGORY = Target.the("hats category")
            .locatedBy("//h1[contains(text(),'HATS')]");

    public static final Target JACKETS_CATEGORY = Target.the("hats category")
            .locatedBy("//h1[contains(text(),'HATS')]");

    public static final Target SNEAKERS_CATEGORY = Target.the("hats category")
            .locatedBy("//h1[contains(text(),'SNEAKERS')]");

    public static final Target WOMENS_CATEGORY = Target.the("hats category")
            .locatedBy("//h1[contains(text(),'WOMENS')]");

    public static final Target MENS_CATEGORY = Target.the("hats category")
            .locatedBy("//h1[contains(text(),'MENS')]");


}
