package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = getDriverWithPAram();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static WebDriver getDriverWithPAram() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--ignore-certificate-errors");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Olha_Koloskova\\chromedriver.exe");
        return new ChromeDriver(option);
    }
}
