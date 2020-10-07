package starter.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static starter.ui.ScheduleForm.LOADING_SPINNER;

public class WaithForLoading implements Performable {

    public static WaithForLoading toFinish() {
        return instrumented(WaithForLoading.class);
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        WaitUntil.the(LOADING_SPINNER, isVisible()).forNoMoreThan(5).seconds().performAs(t);
        WaitUntil.the(LOADING_SPINNER, isNotVisible()).forNoMoreThan(15).seconds().performAs(t);
    }

}
