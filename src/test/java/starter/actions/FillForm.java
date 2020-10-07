package starter.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static starter.ui.ScheduleForm.*;

public class FillForm implements Task {

    private final String name;
    private final String email;
    private final String surname;
    private final String company;
    private final String phone;
    private final String region;

    public FillForm(String name, String surname, String email, String company, String phone, String region) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.company = company;
        this.phone = phone;
        this.region = region;
    }

    public static FillFormBuilder withName(String name) {
        return new FillFormBuilder(name);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(name).into(FIRST_NAME_INPUT),
                Enter.theValue(surname).into(SURNAME_INPUT),
                Enter.theValue(email).into(EMAIL_INPUT),
                Enter.theValue(company).into(COMPANY_NAME_INPUT),
                Enter.theValue(phone).into(PHONE_NUMBER_INPUT),
                SelectFromOptions.byVisibleText(region).from(REGION_DROPDOWN)
        );
    }

    public static class FillFormBuilder {
        private final String name;
        private String surname;
        private String email;
        private String phone;
        private String company;

        public FillFormBuilder(String name) {
            this.name = name;
        }

        public FillFormBuilder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public FillFormBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public FillFormBuilder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public FillFormBuilder withCompany(String company) {
            this.company = company;
            return this;
        }

        public FillForm andRegion(String region) {
            return instrumented(FillForm.class, name, surname, email, company, phone, region);
        }
    }
}
