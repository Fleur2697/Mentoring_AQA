package abstractClasses.page;


import driver.WebDriverFactory;

public abstract class AbstractPage {

    private String pageUrl;

    public void setPageUrl(String pageUrl){
        this.pageUrl = pageUrl;
    }

    public String getPageUrl(){
        return pageUrl;
    }

    public void visitPage(){
        WebDriverFactory.getDriver().get(pageUrl);
    }

}
