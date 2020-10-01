package starter.actions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static starter.ui.SignIn.CART_COUNTER;

public class ShoppingCartQuestions {
    public static Question<Integer> theNumberOfItemsInShoppingCart() {
        return actor -> Text.of(CART_COUNTER).viewedBy(actor).asInteger();
    }

}
