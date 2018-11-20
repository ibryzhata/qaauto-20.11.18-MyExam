package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class FirstListResultPage {

    private WebDriver webDriver;

    @FindBy(xpath = "//div[@id='resultStats']")
    private WebElement resultMessage;

    @FindBy(xpath ="//div[@class='srg']/div[@class='g']")
    private List<WebElement> searchListResults;

    @FindBy(xpath ="//td/a[@aria-label='Page 2']")
    private WebElement secondListResult;


    public FirstListResultPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public boolean isLoaded (){
        return resultMessage.isDisplayed();
    }

    /**
     * Method that counts the number of items in the list on first page
    */

    public int getCountSearchResult() {
        return searchListResults.size();
    }


    /**
     * Method that takes each item from the list and checks for the presence of the search term.
     * @return search Result List;
    */
    public List<String> getSearchListResults() {
        List<String> searchResultLists = new ArrayList<String>();
        for (WebElement searchResult : searchListResults) {
            ((JavascriptExecutor) webDriver)
                    .executeScript("arguments[0].scrollIntoView(true);", searchResult);

            String searchResultText =  searchResult.getText();
            searchResultLists.add(searchResult.getText());
        }
        return searchResultLists;
    }


    /**
     * Method that goes to the second page of the results found
    */

    public SecondListResultPage goTo2Page(){
        WebDriverWait wait=new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(secondListResult));
               secondListResult.click();

        return new SecondListResultPage(webDriver);
    }

}
