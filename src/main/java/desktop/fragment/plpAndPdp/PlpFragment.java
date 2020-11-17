package desktop.fragment.plpAndPdp;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.By;

public class PlpFragment extends AbstractFragment {

    public static By addToCartButton = By.xpath("//form[@id='addToCartForm1776948']");
    public static By productImageReference = By.xpath("//a[@title='<em class=\"search-results-highlight\">Camileo</em> S10 EU']");
    public static By productNameReference = By.xpath("//*[@class='product__list--item'][1]/a[@class='product__list--name']");

    public void clickOnAddToCartButton() {
        clickOnElement(addToCartButton);
    }

    public void clickOnProductImageReference() {
        clickOnElement(productImageReference);
    }

    public void clickOnProductNameReference() {
        clickOnElement(productNameReference);
    }
}
