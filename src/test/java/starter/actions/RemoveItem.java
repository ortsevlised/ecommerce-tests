package starter.actions;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import starter.enums.Categories;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import static starter.ui.CheckOut.REMOVE_ITEM_BTN;

public class RemoveItem implements Task {
    private final String item;

    private RemoveItem(String item) {
        this.item = item;
    }

    public static RemoveItem called(String item) {
        return new RemoveItem(item);
    }

    public static RemoveItem firstInList() {
        return new RemoveItem("");
    }

    @Step("{0} selects #item")
    public <T extends Actor> void performAs(T actor) {
        Target removeItemBtn = REMOVE_ITEM_BTN(item);
        actor.attemptsTo(Open.url("https://jojo-nails.herokuapp.com/checkout/").
                then(Scroll.to(removeItemBtn).then(Click.on(removeItemBtn))));
    }

    /**
     * Gets a random item from the shop data file
     *
     * @param category
     * @return
     * @throws IOException
     */
    private static String getRandomItemNameFrom(Categories category) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(new File("src/test/resources/shop_data.json"));
        JsonNode jsonNode = root.path(category.name().toLowerCase()).path("items");
        System.out.println(jsonNode.size());
        return jsonNode.get(new Random().nextInt(jsonNode.size())).get("name").textValue();
    }
}
