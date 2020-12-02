package stepsDefinitions;

import desktop.fragment.plpAndPdp.PdpFragment;
import io.cucumber.java.en.And;

public class PDpageSteps {
    PdpFragment pdpFragment = new PdpFragment();

    @And("I click on Add to Cart button on PDP")
    public void and_I_click_On_Add_To_Cart_Button_On_PDP() {
        pdpFragment.clickOnAddToCartButton();
    }
}
