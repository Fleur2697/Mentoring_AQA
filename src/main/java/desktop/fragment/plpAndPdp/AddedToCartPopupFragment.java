package desktop.fragment.plpAndPdp;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.By;

public class AddedToCartPopupFragment extends AbstractFragment {

    public static By checkoutButton = By.xpath("//div[@id ='colorbox']//a[contains(text(),'Check Out')]");
    public static By closePopupButton = By.xpath("//button[@id='cboxClose']");

    public void clickOnCheckoutButton(){
        clickOnElement(checkoutButton);
    }
    public void clickOnClosePopupButton(){
        clickOnElement(closePopupButton);
    }
}
