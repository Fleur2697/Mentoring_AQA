package testPack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class Task4EdgeBrowserTest {
    private WebDriver  driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Olha_Koloskova\\msedgedriver.exe");
        driver = new EdgeDriver();
    }

    @Test
    public void openEdgeBrowser() {
        driver.get("https://www.google.com");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
