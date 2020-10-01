package starter.ui;

import net.serenitybdd.screenplay.targets.Target;

public class CheckOut {

    public static final Target REMOVE_ITEM_BTN(String itemName) {
        return Target.the("the remove button")
                .locatedBy("//span[contains(text(),'" + itemName + "')]/../div[@class='remove-button']");
    }
}
