package desktop.fragment.homePage;

import abstractClasses.fragment.AbstractFragment;
import driver.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomeBodyFragment extends AbstractFragment {
    public static By banner = By.xpath("//div[@class='main__inner-wrapper']/div[1]");

    public boolean isBannerDisplayed(){
        return isElementDisplayed(banner);
    }
}



