package starter.actions;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.HoverOverTarget;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import starter.Utils;
import starter.enums.Categories;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddItem implements Task {
    private final String item;
    private Categories category;

    private Target ITEM_IMAGE(String itemName) {
        return Target.the("item selected").locatedBy("//span[contains(text(),'" + itemName + "')]/../..");
    }

    public AddItem(String item, Categories category) {
        this.item = item;
        this.category = category;
    }

    public static AddItem randomlySelected() throws IOException {
        Categories category = Utils.getRandomValueFromEnum(Categories.class);
        String itemName = getRandomItemNameFrom(category);
        return instrumented(AddItem.class, itemName, category);
    }

    private AddItem(String item) {
        this.item = item;
    }

    public static AddItem called(String item) {
        return new AddItem(item);
    }

    public AddItem fromCategory(Categories category) {
        return instrumented(AddItem.class, item, category);
    }

    @Step("{0} selects #item")
    public <T extends Actor> void performAs(T actor) {
        Target itemImage = ITEM_IMAGE(item);
        actor.attemptsTo(Open.url("https://jojo-nails.herokuapp.com/shop/" + category.name().toLowerCase()).
                then(Scroll.to(itemImage).then(HoverOverTarget.over(itemImage))));
        itemImage.resolveFor(actor).thenFind("button").click();
        actor.remember("LAST_ITEM_ADDED",item);
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
