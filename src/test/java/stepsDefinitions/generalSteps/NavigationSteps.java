package stepsDefinitions.generalSteps;

import desktop.pages.GlossUaHomePage;
import desktop.pages.HomePage;
import io.cucumber.java.en.When;


public class NavigationSteps {
    private HomePage homePage = new HomePage();
    private GlossUaHomePage glossUaHomePage = new GlossUaHomePage();

    @When("I open the page {string}")
    public void i_Open_The_Page_PageName(String page) {
        if (page.equals("HomePage")) {
            homePage.visitPage();
        }
        else if(page.equals("GlossUaHomePage")){
            glossUaHomePage.visitPage();
        }
    }
//
//        @When("I open the HomePage")
//        public void i_open_the_home_page () {
//            homePage.visitPage();
//        }
    }
