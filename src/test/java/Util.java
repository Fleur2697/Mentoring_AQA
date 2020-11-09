import org.openqa.selenium.JavascriptExecutor;


public class Util {
    public static void executeScript(String script, Object... elements) {
        ((JavascriptExecutor) WebDriverFactory.getDriver()).executeScript(script, elements);
    }

    public static void scrollToPageBottom() {
        executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

}
