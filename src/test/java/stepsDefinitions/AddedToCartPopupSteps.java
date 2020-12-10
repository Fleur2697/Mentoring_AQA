package stepsDefinitions;

import desktop.fragment.plpAndPdp.AddedToCartPopupFragment;
import io.cucumber.java.en.When;

public class AddedToCartPopupSteps {
    AddedToCartPopupFragment addedToCartPopupFragment = new AddedToCartPopupFragment();

    @When("I click on Checkout button on Added to Cart popup")
    public void i_Click_On_The_Checkout_Button_On_Added_To_Cart_Popup() {
        addedToCartPopupFragment.clickOnCheckoutButton();
    }
}
