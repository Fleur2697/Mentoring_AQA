package desktop.fragment.checkout.cartFragment;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.By;

public class CartActionsFragment extends AbstractFragment {
    public static By checkoutButtonBottom = By.xpath("//div[@class='cart__actions']//button[contains(text(), 'Check Out')]");

    public void clickOnCheckoutButtonBottom(){
        clickOnElement(checkoutButtonBottom);
    }
}
