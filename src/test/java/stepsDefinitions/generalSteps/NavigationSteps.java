package stepsDefinitions.generalSteps;

import desktop.pages.EpamContactUsPage;
import desktop.pages.GlossUaHomePage;
import desktop.pages.HomePage;
import io.cucumber.java.en.When;


public class NavigationSteps {
    private HomePage homePage = new HomePage();
    private GlossUaHomePage glossUaHomePage = new GlossUaHomePage();
    private EpamContactUsPage epamContactUsPage = new EpamContactUsPage();

    @When("I open the page {string}")
    public void i_Open_The_Page_PageName(String page) {
        if (page.equals("HomePage")) {
            homePage.visitPage();
        } else if (page.equals("GlossUaHomePage")) {
            glossUaHomePage.visitPage();
        } else if (page.equals("EpamContactUs")) {
            epamContactUsPage.visitPage();
        }
    }
}
