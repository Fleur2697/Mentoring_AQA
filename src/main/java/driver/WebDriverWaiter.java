package driver;

import driver.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWaiter {
    public WebDriverWait wait;

    public WebDriverWaiter() {
        wait = new WebDriverWait(WebDriverFactory.getDriver(), 30);
    }

    public void waitForElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
