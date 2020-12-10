package stepsDefinitions;

import desktop.fragment.header.HeaderFragment;
import desktop.fragment.homePage.HomeBodyFragment;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.*;


public class HomePageSteps {
    @Then("singInRegister, Navigation Menu and Banner are displaying")
    public void singInRegister_Navigation_Menu_and_Banner_are_displaying() {
        HeaderFragment headerFragment = new HeaderFragment();
        HomeBodyFragment homeBodyFragment= new HomeBodyFragment();
        assertAll("Some element is not displayed",
                () -> assertTrue(headerFragment.isSignInRegisterDisplayed(), "Sign In or Register is not displayed"),
                () -> assertTrue(headerFragment.isNavigationMenuDisplayed(), "Navigation menu is not displayed or shifted"),
                () -> assertTrue(homeBodyFragment.isBannerDisplayed(), "Banner is not displayed or shifted"));

    }

    @And("I enter to search field test product {string} and click on the Search button")
    public void iEnterToSearchFieldTestProductSKUAndClickOnTheSearchButton(String product) {
        HeaderFragment headerFragment = new HeaderFragment();
        headerFragment.fillingSearchField(product);
        headerFragment.clickOnSearchButton();
    }
}
