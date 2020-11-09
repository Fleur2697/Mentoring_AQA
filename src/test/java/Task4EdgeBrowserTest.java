import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Task4EdgeBrowserTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Olha_Koloskova\\msedgedriver.exe");
        driver = new EdgeDriver();
    }

    @Test
    public void openEdgeBrowser() {
        driver.get("https://www.google.com");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
