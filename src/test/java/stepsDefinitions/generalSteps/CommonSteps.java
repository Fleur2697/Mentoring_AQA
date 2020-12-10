package stepsDefinitions.generalSteps;

import driver.WebDriverFactory;
import io.cucumber.java.en.Given;

public class CommonSteps {

    @Given("I am guest user")
    public void i_am_guest_user() {
        WebDriverFactory.getDriver().manage().deleteAllCookies();
    }
}

