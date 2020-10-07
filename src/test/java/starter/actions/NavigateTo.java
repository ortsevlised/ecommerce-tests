package starter.actions;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import starter.ui.ScheduleForm;

public class NavigateTo {

    public static Performable formPage() {
        return Task.where("{0} opens the form page",
                Open.browserOn().the(ScheduleForm.class));
    }
}
