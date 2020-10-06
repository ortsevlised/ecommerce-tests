package starter.ui;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("/shop")
public class ShopPage extends PageObject {
    public static By CATEGORIES = By.className("collection-preview");
    public static By ITEMS=By.className("collection-item");
}
