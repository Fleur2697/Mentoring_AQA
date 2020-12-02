package desktop.fragment.checkout.signInRegisterFragment;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.By;

public class SingInRegisterFragment extends AbstractFragment {
    public static By inputEmailField = By.xpath("//*[@id ='guest.email']");
    public static By inputEmailConfirmField = By.xpath("//*[@id ='guest.confirm.email']");
    public static By checkoutAsGuestButton = By.xpath("//button[contains(text(), 'Check Out as a Guest')]");

    public void fillingInputEmailField(String email) {
        fillingField(inputEmailField, email);
    }

    public void fillingInputEmailConfirmField(String confirmEmail) {
        fillingField(inputEmailConfirmField, confirmEmail);
    }

    public void clickOnCheckoutAsGuestButton() {
        clickOnElement(checkoutAsGuestButton);
    }
}
