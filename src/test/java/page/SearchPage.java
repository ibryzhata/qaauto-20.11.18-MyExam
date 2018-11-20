package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class SearchPage {
    private WebDriver webDriver;


    @FindBy(xpath ="//input[@name='q']")
    private WebElement searchField;

    public SearchPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded (){
        return webDriver.getCurrentUrl().equals("https://www.google.com/")
                && webDriver.getTitle().contains("Google")
                && searchField.isDisplayed();
    }

    public FirstListResultPage search(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchField.submit();

        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new FirstListResultPage (webDriver);
    }
}
