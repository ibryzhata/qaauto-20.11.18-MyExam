package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.FirstListResultPage;
import page.SearchPage;
import page.SecondListResultPage;

import java.util.List;

import static java.lang.Thread.sleep;


public class SearchTest {
    private WebDriver webDriver;
    SearchPage searchPage;

    @BeforeMethod
    public void beforeMethod() {
        webDriver = new FirefoxDriver();
        searchPage = new SearchPage(webDriver);
        webDriver.get("https://www.google.com/");
    }

    @AfterMethod
    public void afterMethod() {
        webDriver.quit();
    }


    @Test
    public void SearchTest() {

        String searchTerm = "Selenium";

        Assert.assertTrue(searchPage.isPageLoaded(), "Search page is not loaded");

        FirstListResultPage firstListResultPage = searchPage.search(searchTerm);
       Assert.assertTrue(firstListResultPage.isLoaded(), "firstListResultPage is not loaded");

        Assert.assertEquals(firstListResultPage.getCountSearchResult(), 10, "SearchResult count is wrong");

        List<String> searchResultLists = firstListResultPage.getSearchListResults();
        for (String searchResult : searchResultLists) {
        Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),
                    "SearchTerm" + searchTerm + "not found in " + searchResult);


        SecondListResultPage secondListResultPage = firstListResultPage.goTo2Page();

        Assert.assertEquals(secondListResultPage.getCountSearchSecondResult(), 10, "SearchResult count is wrong");

            List<String> searchSecondResultLists = secondListResultPage.getSearchSecondResultLists();
        for (String  searchSecondResultList : searchSecondResultLists) {
        Assert.assertTrue(searchSecondResultList.toLowerCase().contains(searchTerm.toLowerCase()),
                        "SearchTerm" + searchTerm + "not found in " + searchSecondResultLists);
            }
        }
    }
}
