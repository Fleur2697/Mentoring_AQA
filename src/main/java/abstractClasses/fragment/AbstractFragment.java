package abstractClasses.fragment;

import driver.WebDriverWaiter;
import driver.WebDriverFactory;
import org.openqa.selenium.By;

public abstract class AbstractFragment extends WebDriverWaiter {

    public void clickOnElement(By locator) {
        waitForElement(locator);
        WebDriverFactory.getDriver().findElement(locator).click();
    }

    public void fillingField(By locator, String text) {
        WebDriverFactory.getDriver().findElement(locator).sendKeys(text);
    }

    public boolean isElementDisplayed(By locator) {
        return WebDriverFactory.getDriver().findElement(locator).isDisplayed();
    }

    public String getElementText(By locator){
        return WebDriverFactory.getDriver().findElement(locator).getText();
    }
}
