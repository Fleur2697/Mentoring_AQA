package desktop.fragment.checkout.cartFragment;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartTotalsFragment extends AbstractFragment {
    @FindBy(xpath = "//div[@class='cart-totals']//div[@class='col-xs-6 cart-totals-right text-right']")
    private WebElement rootElement;

    public static By cartSubtotal = By.xpath("//div[@class='cart-totals']//div[@class='col-xs-6 cart-totals-right text-right']");
    public static By grandTotal = By.xpath("//div[@class='cart-totals']//div[@class='col-xs-6 cart-totals-right text-right grand-total']");

    public String getTextCartSubtotal() {
        return getElementText(cartSubtotal);
    }

    public String getTextGrandTotal(){
        return getElementText(grandTotal);
    }

}
