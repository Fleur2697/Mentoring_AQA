package desktop.fragment.checkout.shipmentPickUpLocationFragment;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.By;

public class ShipmentPickUpLocationFragment extends AbstractFragment {
    public static By subtotalOnCheckout = By.xpath("//div[@class='subtotal']");
    public static By totalOnCheckout = By.xpath("//div[@class='totals']");
    public static By taxOnCheckout = By.xpath("//div[@class='realTotals']");

    public String getTextSubtotalOnCheckout(){
        return getElementText(subtotalOnCheckout);
    }

    public String getTextTotalOnCheckout(){
        return getElementText(totalOnCheckout);
    }

    public String getTextTaxOnCheckout(){
        return getElementText(taxOnCheckout);
    }
}
