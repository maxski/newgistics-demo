package com.ibs.pages;

import org.openqa.selenium.By;
import org.testng.Reporter;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by pc on 21.04.2016.
 */

public class SearchPage{

    private void enterDestination(String destination){
        Reporter.log("Enter destination: " + destination, true);
        $(By.id("ss")).sendKeys(destination);
    }

    private void selectDestinationFromPopup(String destination){
        Reporter.log("Select destination from pop-up: " + destination, true);
        $(By.xpath("//b[@class='search_hl_name' and .='" + destination + "']")).click();
    }

    private void setDestination(String destination){
        enterDestination(destination);
        selectDestinationFromPopup(destination);
    }

    private void setStartDay(String day){
        Reporter.log("Set start day: " + day, true);
        $(By.name("checkin_monthday")).selectOptionByValue(day);
    }

    private void setStartMonth(String month){
        Reporter.log("Set start month: " + month, true);
        $(By.name("checkin_year_month")).selectOptionByValue(month);
    }

    private void setEndDay(String day){
        Reporter.log("Set end day: " + day, true);
        $(By.name("checkout_monthday")).selectOptionByValue(day);
    }

    private void setDates(String startDate, String endDate){
        String startDay = getDay(startDate);
        String startMonth = getMonth(startDate);
        String endDay = getDay(endDate);
        setStartDay(startDay);
        setStartMonth(startMonth);
        setEndDay(endDay);
    }

    private String getDay(String date){
        return date.substring(date.lastIndexOf("-") + 1);
    }

    private String getMonth(String date){
        return date.substring(0, date.lastIndexOf("-"));
    }

    private void initiateSearch(){
        Reporter.log("Start Search", true);
        $("button").submit();
    }

    public ResultPage searchByCriteria(String destination, String startDate, String endDate){
        setDestination(destination);
        setDates(startDate, endDate);
        initiateSearch();
        return new ResultPage();
    }
}
