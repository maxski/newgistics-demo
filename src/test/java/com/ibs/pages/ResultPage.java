package com.ibs.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.Iterator;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by pc on 24.04.2016.
 */
public class ResultPage {
    private SelenideElement getHeader(){
        return $("h1");
    }

    private ElementsCollection getResultsLocation(){
        return $$(By.xpath("//div[@class='address']/a"));
    }

    public void verifyResultsHeaderContains(String destination){
        Reporter.log("Verify result header location contains searched destination. Destination: " + destination + " . Header is: " + getHeader().getText(), true);
        getHeader().shouldHave(text(destination));
    }

    public void verifyResultsLocationContains(String destination){
        ElementsCollection locations = getResultsLocation();
        Reporter.log("Verify results location contains searched destination. Destination : " + destination, true);
        for(int i = 0; i < locations.size(); i++){
            SelenideElement el = locations.get(i);
            Reporter.log("Result " + i + " location: " + el.getText(), true);
            el.shouldHave(text(destination));
        }
    }
}
