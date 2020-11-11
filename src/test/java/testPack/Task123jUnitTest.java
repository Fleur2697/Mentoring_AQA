package testPack;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Util;
import util.WebDriverFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
public class Task123jUnitTest {
    private static WebDriver driver = WebDriverFactory.getDriver();
    private static By logo = By.xpath("//div[@class ='nav__left js-site-logo']");
    private static By singInRegister = By.xpath("//header//li[@class='liOffcanvas']");
    private static By searchButton = By.cssSelector("button.js_search_button");
    private static By searchField = By.id("js-site-search-input");
    private static By navigationMenu = By.cssSelector("ul.js-offcanvas-links");
    private static By banner = By.xpath("//div[@class='main__inner-wrapper']/div[1]");
    private static By addToCartButton = By.xpath("//button[@id='addToCartButton']");
    private static By checkoutButton = By.xpath("//div[@id ='colorbox']//a[contains(text(),'Check Out')]");
    private static By cartSubtotal = By.xpath("//div[@class='cart-totals']//div[@class='col-xs-6 cart-totals-right text-right']");
    private static By grandTotal = By.xpath("//div[@class='cart-totals']//div[@class='col-xs-6 cart-totals-right text-right grand-total']");
    private static By checkoutButtonHead = By.xpath("//div[@class='cart__actions border']//button[contains(text(), 'Check Out')]");
    private static By inputEmailField = By.xpath("//*[@id ='guest.email']");
    private static By inputEmailConfirmField = By.xpath("//*[@id ='guest.confirm.email']");
    private static By checkoutAsGuestButton = By.xpath("//button[contains(text(), 'Check Out as a Guest')]");
    private static By subtotalOnCheckout = By.xpath("//div[@class='subtotal']");
    private static By totalOnCheckout = By.xpath("//div[@class='totals']");
    private static By taxOnCheckout = By.xpath("//div[@class='realTotals']");
    WebDriverWait wait = new WebDriverWait(driver, 30);

    @BeforeEach
    public void pashaMethod(TestInfo info) {
        String displayName = info.getDisplayName();
        if ("Locate Elements".equals(displayName) || "Show Title and URL".equals(displayName) || "Total and Subtotal check".equals(displayName)) {
            driver.get("https://ecse00100f2f.epam.com:9002/yacceleratorstorefront/?site=electronics");
        } else if ("Work with elements".equals(displayName)){
            driver.get("https://gloss.ua/");
        }

    }

    @Test
    @DisplayName("Locate Elements")
    public void locateElements() {
        driver.findElement(logo).click();
        driver.findElement(singInRegister);
        driver.findElement(navigationMenu);
        driver.findElement(banner);
        driver.findElement(searchField).sendKeys("camileo");
        driver.findElement(searchButton).click();
        driver.findElement(By.id("addToCartForm1776948")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[@id='cboxClose']")).click();
        driver.findElement(By.xpath("//a[@title='<em class=\"search-results-highlight\">Camileo</em> S10 EU']")).click();
    }


    public void showPageTitleAndPageURL() {
        String pageTitle = driver.getTitle();
        String pageUrl = driver.getCurrentUrl();
        System.out.println("Page title is " + pageTitle + " and Page URL is " + pageUrl);
    }

    @DisplayName("Show Title and URL")
    @Test
    public void showPageTitleAndUrl() {
        showPageTitleAndPageURL();
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://ecse00100f2f.epam.com:9002/yacceleratorstorefront/electronics/en/Open-Catalogue/Cameras/Film-cameras/c/574");
        showPageTitleAndPageURL();
        driver.switchTo().window(tabs.get(0));
        driver.navigate().refresh();
        showPageTitleAndPageURL();
    }

    @Test
    @DisplayName("Work with elements")
    public void workWithMultipleElements() {
        while (!(driver.findElements(By.cssSelector("h4")).size() == 62)) {
            Util.scrollToPageBottom();
        }
        List<WebElement> titles = driver.findElements(By.cssSelector("h4"));
        System.out.println(titles.size());
        for (WebElement i : titles) {
            System.out.println(i.getText());
        }
    }


    @Test
    @DisplayName("Total and Subtotal check")
    public void totalAndSubtotalForGuestUserOnCheckoutFlow() {
        driver.findElement(searchField).sendKeys("1934793");
        driver.findElement(searchButton).click();
        driver.findElement(By.xpath("//*[@class='product__list--item'][1]/a[@class='product__list--name']")).click();
        //Precondition
        driver.findElement(addToCartButton).click();
        WebElement checkoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id ='colorbox']//a[contains(text(),'Check Out')]")));
        checkoutButton.click();
        assertEquals("$99.85", driver.findElement(cartSubtotal).getText(), "Cart subtotal is not like expected on the basket page");
        assertEquals("$99.85", driver.findElement(grandTotal).getText(), "Cart total is not like expected on the basket page");
        driver.findElement(checkoutButtonHead).click();
        driver.findElement(inputEmailField).sendKeys("test@user.com");
        driver.findElement(inputEmailConfirmField).sendKeys("test@user.com");
        driver.findElement(checkoutAsGuestButton).click();
        assertAll("Some price in not like expected on Checkout flow",
                () ->assertEquals(("Subtotal:\n" + "$99.85"), driver.findElement(subtotalOnCheckout).getText(), "Cart subtotal is not like expected on the Shipping Address page"),
                () ->assertEquals(("ORDER TOTAL\n" + "$99.85"), driver.findElement(totalOnCheckout).getText(), "Cart total is not like expected on the Shipping Address page"),
                () ->assertEquals(("Your order includes $4.75 tax."), driver.findElement(taxOnCheckout).getText(), "Taxes is not like expected on the Shipping Address page")
        );


    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }


}




