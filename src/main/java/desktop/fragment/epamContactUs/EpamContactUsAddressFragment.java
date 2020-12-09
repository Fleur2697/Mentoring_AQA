package desktop.fragment.epamContactUs;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.By;

public class EpamContactUsAddressFragment extends AbstractFragment {

    public static By address = By.xpath("//p[@style =\"text-align: center;\"]/b");

    public String getAddress() {
        return getElementText(address);
    }

}
