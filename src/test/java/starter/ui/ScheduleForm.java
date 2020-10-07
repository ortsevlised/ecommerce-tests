package starter.ui;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("http://www.byte2bite.com/b2b/form2/")
public class ScheduleForm extends UIInteractionSteps {

    public static final Target FIRST_NAME_INPUT = Target.the("name input")
            .locatedBy("#firstname");

    public static final Target SURNAME_INPUT = Target.the("surname input")
            .locatedBy("#lastname");

    public static final Target EMAIL_INPUT = Target.the("email input")
            .locatedBy("#email");

    public static final Target COMPANY_NAME_INPUT = Target.the("company input")
            .locatedBy("#company");

    public static final Target PHONE_NUMBER_INPUT = Target.the("phone input")
            .located(By.name("phone-number"));

    public static final Target REGION_DROPDOWN = Target.the("region select")
            .located(By.id("region__c"));


    public static final Target SUBMIT_BTN = Target.the("submit button")
            .located(By.xpath("//button[contains(text(),'PICK A TIME')]"));

    public static final Target LOADING_SPINNER = Target.the("loading")
            .located(By.id("loadImg"));

    public static final Target CHILIPIPER_FRAME = Target.the("phone input")
            .located(By.className("chilipiper-frame"));

    public static final Target SCHEDULE_FORM = Target.the("phone input")
            .located(By.className("fabe-availability-mobile"));

}
