package stepsDefinitions.generalSteps;

import io.cucumber.java.Before;

import static driver.WebDriverFactory.getDriver;

public class Hooks {

    public Hooks() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            getDriver().quit();
        }));
    }


    @Before
    public void setup() {
        getDriver();
    }
}
