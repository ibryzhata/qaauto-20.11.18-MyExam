package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SecondListResultPage {
    private WebDriver webDriver;

    @FindBy(xpath = "///a[@id='pnprev']")
    private WebElement previousPage;

    @FindBy(xpath ="//div[@class='g']")
    private List<WebElement> searchSecondListResults;

    public SecondListResultPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Method that counts the number of items in the list on first page
     */

    public int getCountSearchSecondResult() {
        return searchSecondListResults.size();
    }

    /**
     * Method that takes each item from the list and checks for the presence of the search term.
     * @return search Result List;
     */

    public List<String> getSearchSecondResultLists() {
        List<String> searchResultListsSecond = new ArrayList<String>();
        for (WebElement searchResultListSecond : searchSecondListResults) {
            ((JavascriptExecutor) webDriver)
                    .executeScript("arguments[0].scrollIntoView(true);", searchResultListSecond);

            String searchResultListsSecondText =  searchResultListSecond.getText();
            searchResultListsSecond.add(searchResultListSecond.getText());
        }
        return searchResultListsSecond;
    }
}
