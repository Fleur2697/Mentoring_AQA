package testPack;

import desktop.fragment.checkout.cartFragment.CartActionsFragment;
import desktop.fragment.checkout.cartFragment.CartTotalsFragment;
import desktop.fragment.checkout.shipmentPickUpLocationFragment.ShipmentPickUpLocationFragment;
import desktop.fragment.checkout.signInRegisterFragment.SingInRegisterFragment;
import desktop.fragment.header.HeaderFragment;
import desktop.fragment.homePage.HomeBodyFragment;
import desktop.fragment.plpAndPdp.AddedToCartPopupFragment;
import desktop.fragment.plpAndPdp.PdpFragment;
import desktop.fragment.plpAndPdp.PlpFragment;
import desktop.pages.GlossUaHomePage;
import desktop.pages.HomePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import driver.Util;
import driver.WebDriverFactory;

import java.util.List;

import static desktop.fragment.commonFragment.CommonFragment.showPageTitleAndPageURL;
import static org.junit.jupiter.api.Assertions.*;

public class Task123jUnitTest {

    private HeaderFragment headerFragment = new HeaderFragment();
    private HomeBodyFragment homeBodyFragment = new HomeBodyFragment();
    private PlpFragment plpFragment = new PlpFragment();
    private PdpFragment pdpFragment = new PdpFragment();
    private AddedToCartPopupFragment addedToCartPopupFragment = new AddedToCartPopupFragment();
    private CartActionsFragment cartActionsFragment = new CartActionsFragment();
    private SingInRegisterFragment singInRegisterFragment = new SingInRegisterFragment();
    private CartTotalsFragment cartTotalsFragment = new CartTotalsFragment();
    private ShipmentPickUpLocationFragment shipmentPickUpLocationFragment = new ShipmentPickUpLocationFragment();
    private HomePage homePage = new HomePage();
    private GlossUaHomePage glossUaHomePage =  new GlossUaHomePage();

    private static WebDriver driver = WebDriverFactory.getDriver();

    @BeforeEach
    public void getStartLink(TestInfo info) {
        String displayName = info.getDisplayName();
        if ("Locate Elements".equals(displayName) || "Show Title and URL".equals(displayName) || "Total and Subtotal check".equals(displayName)) {
            homePage.visitPage();
        } else if ("Work with elements".equals(displayName)) {
            glossUaHomePage.visitPage();
        }

    }

    @Test
    @DisplayName("Locate Elements")
    public void locateElements() {
        headerFragment.clickOnLogo();
        assertAll("Some element is not displayed",
                () -> assertTrue(headerFragment.isSignInRegisterDisplayed(), "Sign In or Register is not displayed"),
                () -> assertTrue(headerFragment.isNavigationMenuDisplayed(), "Navigation menu is not displayed or shifted"),
                () -> assertTrue(homeBodyFragment.isBannerDisplayed(), "Banner is not displayed or shifted"));
        headerFragment.fillingSearchField("camileo");
        headerFragment.clickOnSearchButton();
        plpFragment.clickOnAddToCartButton();
        addedToCartPopupFragment.clickOnClosePopupButton();
        plpFragment.clickOnProductImageReference();
    }


    @DisplayName("Show Title and URL")
    @Test
    public void showPageTitleAndUrl() {
        //сравнивать название страницы
        showPageTitleAndPageURL();
        Util.openNewTab();
        Util.switchToTab(1);
        driver.get("https://ecse00100f2f.epam.com:9002/yacceleratorstorefront/electronics/en/Open-Catalogue/Cameras/Film-cameras/c/574");
        showPageTitleAndPageURL();
        Util.switchToTab(0);
        Util.refreshPage();
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
        headerFragment.fillingSearchField("1934793");
        headerFragment.clickOnSearchButton();
        plpFragment.clickOnProductNameReference();
        //Precondition
        pdpFragment.clickOnAddToCartButton();
        addedToCartPopupFragment.clickOnCheckoutButton();
        assertAll("Some price in not like expected on the Basket page",
                () -> assertEquals("$99.85", cartTotalsFragment.getTextCartSubtotal(), "Cart subtotal is not like expected on the basket page"),
                () -> assertEquals("$99.85", cartTotalsFragment.getTextGrandTotal(), "Cart total is not like expected on the basket page"));
        cartActionsFragment.clickOnCheckoutButtonBottom();
        singInRegisterFragment.fillingInputEmailField("test@user.com");
        singInRegisterFragment.fillingInputEmailConfirmField("test@user.com");
        singInRegisterFragment.clickOnCheckoutAsGuestButton();
        assertAll("Some price in not like expected on Checkout flow",
                () -> assertEquals(("Subtotal:\n" + "$99.85"), shipmentPickUpLocationFragment.getTextSubtotalOnCheckout(), "Cart subtotal is not like expected on the Shipping Address page"),
                () -> assertEquals(("ORDER TOTAL\n" + "$99.85"), shipmentPickUpLocationFragment.getTextTotalOnCheckout(), "Cart total is not like expected on the Shipping Address page"),
                () -> assertEquals(("Your order includes $4.75 tax."), shipmentPickUpLocationFragment.getTextTaxOnCheckout(), "Taxes is not like expected on the Shipping Address page")
        );


    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }


}




