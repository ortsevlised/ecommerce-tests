package starter;


import io.restassured.path.json.JsonPath;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Assert;

import java.util.Arrays;
import java.util.Map;

import static org.hamcrest.Matchers.*;

public class ValidateResponse {



    private static final String OR = "<<OR>>";


    public static Matcher switchMatchers(String comparison, String expectedValue) {
        Matcher matcher = null;
        if (expectedValue.equalsIgnoreCase("null")) {
            expectedValue = null;
        }
        switch (comparison) {
            case "is":
            case "=":
                matcher = is(expectedValue);
                break;
            case "not":
                matcher = not(expectedValue);
                break;
            case ">":
                matcher = greaterThan(expectedValue);
                break;
            case "<":
                matcher = lessThan(expectedValue);
                break;
            case "endsWith":
                matcher = endsWith(expectedValue);
                break;
            case "contains":
                matcher = containsString(expectedValue);
                break;
            case "is_any_of":
                String[] values = expectedValue.split(OR);
                matcher = Matchers.isOneOf(values[0], values[1]);
                break;
            case "doesnt_contain":
                matcher = not(containsString(expectedValue));
                break;
            case "is_empty_or_null":
                matcher = isEmptyOrNullString();
                break;
        }
        return matcher;
    }

    /**
     * Check that fields in the fieldValues meet the assertion criteria in the assertions field.
     * Asserts that the field does exist in the map and that it meets the criteria as per assertions.
     *
     * @param assertions  fields and assertions.
     * @param fieldValues fieldValues i.e fieldName -> fieldValue
     */
    public static void validateFieldValues(String assertions, Map fieldValues) {
        String[] assertion = assertions.split(",|(and)");
        Arrays.stream(assertion).forEach((checks) -> {
            String[] check = checks.trim().split(" ", 3);
            Assert.assertThat("The field " + check[0] + " is not found ", fieldValues.get(check[0]), Matchers.notNullValue());
            if (!check[2].equalsIgnoreCase("present")) {
                if (check[2].equalsIgnoreCase("empty")) {
                    check[2] = "";
                }
                MatcherAssert.assertThat(check[0] + " should be " + check[2], fieldValues.get(check[0]).toString().trim(), switchMatchers(check[1], check[2]));
            }
        });
    }

    public static void validateFieldValues(String assertions, JsonPath fieldValues) {
        String[] assertion = assertions.split(",|(and)");
        Arrays.stream(assertion).forEach((checks) -> {
            String[] check = checks.trim().split(" ", 3);
            Assert.assertThat("The field " + check[0] + " is not found ", fieldValues.get(check[0]), Matchers.notNullValue());
            if (!check[2].equalsIgnoreCase("present")) {
                if (check[2].equalsIgnoreCase("empty")) {
                    check[2] = "";
                }
                MatcherAssert.assertThat(check[0] + " should be " + check[2], fieldValues.get(check[0]).toString().trim(), switchMatchers(check[1], check[2]));
            }
        });
    }


}


