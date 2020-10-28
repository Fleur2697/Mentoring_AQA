import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task123Test {
    private static final Thread CLOSE_THREAD = new Thread(() -> WebDriverFactory.getDriver().quit());

    static {
        Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
    }

    @Test
    public void locateElements() {
        WebDriverFactory.getDriver().get("https://ecse00100f2f.epam.com:9002/yacceleratorstorefront/?site=electronics");
        WebElement logo = WebDriverFactory.getDriver().findElement(By.xpath("/html//nav[1]//img"));
        WebElement singInRegister = WebDriverFactory.getDriver().findElement(By.xpath("/html//nav[1]//div[2]/div//a"));
        WebElement searchButton = WebDriverFactory.getDriver().findElement(By.cssSelector("button.js_search_button"));
        WebElement searchField = WebDriverFactory.getDriver().findElement(By.id("js-site-search-input"));
        WebElement navigationMenu = WebDriverFactory.getDriver().findElement(By.cssSelector("ul.js-offcanvas-links"));
        WebElement banner = WebDriverFactory.getDriver().findElement(By.xpath("/html//main/div[3]/div[1]"));
        searchField.sendKeys("camileo");
        searchButton.click();
        WebDriverFactory.getDriver().findElement(By.id("addToCartForm1776948")).click();
        WebDriverFactory.getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebDriverFactory.getDriver().findElement(By.xpath("//*[@id=\"cboxClose\"]")).click();
        WebDriverFactory.getDriver().findElement(By.xpath("/html//li[2]//img")).click();
    }


    public void showPageTitleAndPageURL() {
        String pageTitle = WebDriverFactory.getDriver().getTitle();
        String pageUrl = WebDriverFactory.getDriver().getCurrentUrl();
        System.out.println("Page title is " + pageTitle + " and Page URL is " + pageUrl);
    }

    @Test
    public void showPageTitleAndUrl() {
        WebDriverFactory.getDriver().get("https://ecse00100f2f.epam.com:9002/yacceleratorstorefront/?site=electronics");
        showPageTitleAndPageURL();
        ((JavascriptExecutor) WebDriverFactory.getDriver()).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(WebDriverFactory.getDriver().getWindowHandles());
        WebDriverFactory.getDriver().switchTo().window(tabs.get(1));
        WebDriverFactory.getDriver().get("https://ecse00100f2f.epam.com:9002/yacceleratorstorefront/electronics/en/Open-Catalogue/Cameras/Film-cameras/c/574");
        showPageTitleAndPageURL();
        WebDriverFactory.getDriver().switchTo().window(tabs.get(0));
        WebDriverFactory.getDriver().navigate().refresh();
        showPageTitleAndPageURL();
    }


    @Test
    public void workWithMultipleElements() {
        WebDriverFactory.getDriver().get("https://gloss.ua/");
        while (!(WebDriverFactory.getDriver().findElements(By.cssSelector("h4")).size() == 62)) {
            Util.scrollToPageBottom();
        }
        List<WebElement> titles = WebDriverFactory.getDriver().findElements(By.cssSelector("h4"));
        System.out.println(titles.size());
        for (WebElement i : titles) {
            System.out.println(i.getText());
        }
    }


}




