package desktop.fragment.plpAndPdp;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.By;

public class PdpFragment extends AbstractFragment {
    public static By addToCartButton = By.xpath("//button[@id='addToCartButton']");

    public void clickOnAddToCartButton() {
        clickOnElement(addToCartButton);
    }
}

