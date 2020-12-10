package driver;

import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Util {

    public static void executeScript(String script, Object... elements) {
        ((JavascriptExecutor) WebDriverFactory.getDriver()).executeScript(script, elements);
    }

    public static void scrollToPageBottom() {
        executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void openNewTab() {
        executeScript("window.open()");
    }

    public static void switchToTab(int tabIndex) {
        WebDriverFactory.getDriver().switchTo().window(handleTab(tabIndex));
    }

    public static String handleTab(int tabIndex) {
        ArrayList<String> tabs = new ArrayList<>(WebDriverFactory.getDriver().getWindowHandles());
        return tabs.get(tabIndex);
    }

    public static void refreshPage() {
        WebDriverFactory.getDriver().navigate().refresh();

    }

    public static String getValueByRegEx(String text, String pattern, int group) {
        Pattern replacementPattern = Pattern.compile(pattern);
        Matcher matcher = replacementPattern.matcher(text);
        matcher.find();
        return matcher.group(group);
    }

    public static String getValueByRegEx(String text, String pattern) {
        int firstGroup = 0;
        return getValueByRegEx(text, pattern, firstGroup);
    }


}
