package desktop.fragment.header;

import abstractClasses.fragment.AbstractFragment;
import driver.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderFragment extends AbstractFragment {
    public static WebDriver driver = WebDriverFactory.getDriver();
    public static By logo = By.xpath("//div[@class ='nav__left js-site-logo']");
    public static By singInRegister = By.xpath("//header//li[@class='liOffcanvas']");
    public static By searchButton = By.cssSelector("button.js_search_button");
    public static By searchField = By.id("js-site-search-input");
    public static By navigationMenu = By.cssSelector("ul.js-offcanvas-links");


    public void clickOnLogo() {
        clickOnElement(logo);
    }

    public void clickOnSearchButton() {
        clickOnElement(searchButton);
    }

    public boolean isSignInRegisterDisplayed() {
        return isElementDisplayed(singInRegister);
    }

    public boolean isNavigationMenuDisplayed() {
        return isElementDisplayed(navigationMenu);
    }

    public void fillingSearchField(String searchText){
        fillingField(searchField, searchText);
    }
}
