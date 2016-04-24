package com.ibs;

import com.ibs.driver.BaseTest;
import com.ibs.pages.SearchPage;
import com.ibs.pages.ResultPage;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

/**
 * Created by pc on 22.04.2016.
 */
public class SearchResultsTest extends BaseTest{

    @BeforeMethod
    public void beforeTest(){
        openUrl(getConfigProperty("url"));
    }

    @Parameters({"destination", "startDate", "endDate"})
    @Test
    public void firstResultsPageLocation(String destination, String startDate, String endDate){
        SearchPage searchPage = new SearchPage();
        ResultPage resultPage = searchPage.searchByCriteria(destination, startDate, endDate);
        resultPage.verifyResultsHeaderContains(destination);
        resultPage.verifyResultsLocationContains(destination);

    }

    @Parameters({"destination", "startDate", "endDate"})
    @Test
    public void firstResultsPageHeaderLocation(String destination, String startDate, String endDate){
        SearchPage searchPage = new SearchPage();
        ResultPage resultPage = searchPage.searchByCriteria(destination, startDate, endDate);
        resultPage.verifyResultsHeaderContains(destination);
    }
}
