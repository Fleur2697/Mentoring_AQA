package stepsDefinitions;

import desktop.fragment.plpAndPdp.PlpFragment;
import io.cucumber.java.en.And;


public class PLpageSteps {
    PlpFragment plpFragment = new PlpFragment();

    @And("I click on the product name reference on PLP")
    public void i_Click_On_The_Product_Name_Reference_On_PLP() {
        plpFragment.clickOnProductNameReference();
    }
}
