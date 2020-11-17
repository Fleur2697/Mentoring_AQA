package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class WebDriverFactory {

    private static WebDriver driverE;
    private static WebDriver driver;


    public static WebDriver getDriver() {
        if (driver == null) {
            driver = getDriverCapabilities();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static WebDriver getDriverCapabilities() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--ignore-certificate-errors");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        return new ChromeDriver(option);
    }


}
