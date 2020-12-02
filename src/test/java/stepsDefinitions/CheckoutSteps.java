package stepsDefinitions;

import desktop.fragment.checkout.cartFragment.CartActionsFragment;
import desktop.fragment.checkout.cartFragment.CartTotalsFragment;
import desktop.fragment.checkout.shipmentPickUpLocationFragment.ShipmentPickUpLocationFragment;
import desktop.fragment.checkout.signInRegisterFragment.SingInRegisterFragment;
import driver.WebDriverFactory;
import dto.PricesRows;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.After;
import org.junit.jupiter.api.AfterAll;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutSteps {
    CartTotalsFragment cartTotalsFragment = new CartTotalsFragment();
    CartActionsFragment cartActionsFragment = new CartActionsFragment();
    ShipmentPickUpLocationFragment shipmentPickUpLocationFragment = new ShipmentPickUpLocationFragment();
    SingInRegisterFragment singInRegisterFragment = new SingInRegisterFragment();

    @DataTableType
    public PricesRows defineGrocery(Map<String, String> entry) {
        return new PricesRows(entry.get("subTotal"), entry.get("total"), entry.get("taxes"));
    }


    @Then("I see Total and Subtotal on Basket page and they are")
    public void iSeeTotalAndSubtotalOnBasketPageAndTheyAre(List<PricesRows> expectedOrderPrice) {
        PricesRows expectedPrice = expectedOrderPrice.get(0);
        assertAll("Some price in not like expected on the Basket page",
                () -> assertEquals(expectedPrice.subTotal, cartTotalsFragment.getTextCartSubtotal(),
                        "Cart subtotal is not like expected on the basket page"),
                () -> assertEquals(expectedPrice.total, cartTotalsFragment.getTextGrandTotal(),
                        "Cart total is not like expected on the basket page"));
    }

    @And("I click on the bottom Checkout button")
    public void i_Click_On_The_Bottom_Checkout_Button() {
        cartActionsFragment.clickOnCheckoutButtonBottom();
    }


    @And("I see Total and Subtotal on Shipment page")
    public void i_See_Total_And_Subtotal_On_Shipment_Page(List<PricesRows> expectedOrderPrice) {
        PricesRows expectedPrice = expectedOrderPrice.get(0);
        assertAll("Some price in not like expected on Checkout flow",
                () -> assertEquals(expectedPrice.subTotal, shipmentPickUpLocationFragment.getTextSubtotalOnCheckout(),
                        "Cart subtotal is not like expected on the Shipping Address page"),
                () -> assertEquals(expectedPrice.total, shipmentPickUpLocationFragment.getTextTotalOnCheckout(),
                        "Cart total is not like expected on the Shipping Address page"),
                () -> assertEquals(expectedPrice.taxes, shipmentPickUpLocationFragment.getTextTaxOnCheckout(),
                        "Taxes is not like expected on the Shipping Address page")
        );
    }

    @And("I enter my email {string} to Email and Confirm email fields")
    public void i_Enter_My_Email_To_Email_And_Confirmation_email_fields(String email) {
        singInRegisterFragment.fillingInputEmailField(email);
        singInRegisterFragment.fillingInputEmailConfirmField(email);
    }

    @And("I click on \"Checkout as Guest\" button")
    public void i_Click_On_Checkout_As_Guest_Button() {
        singInRegisterFragment.clickOnCheckoutAsGuestButton();
    }

    @AfterAll()
    public void closeBrowser() {
        WebDriverFactory.getDriver().quit();
    }
}
