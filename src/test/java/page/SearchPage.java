package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

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
        WebDriverWait wait = new WebDriverWait(webDriver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='g']|// div/h3[@class='bNg8Rb']")));

        return new FirstListResultPage (webDriver);
    }
}