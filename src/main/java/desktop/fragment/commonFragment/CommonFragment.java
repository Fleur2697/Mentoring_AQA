package desktop.fragment.commonFragment;

import driver.WebDriverFactory;

public class CommonFragment {
    public static void showPageTitleAndPageURL() {
        String pageTitle = WebDriverFactory.getDriver().getTitle();
        String pageUrl = WebDriverFactory.getDriver().getCurrentUrl();
        System.out.println("Page title is " + pageTitle + " and Page URL is " + pageUrl);
    }
}
