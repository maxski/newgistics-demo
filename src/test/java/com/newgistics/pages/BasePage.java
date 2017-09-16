package com.newgistics.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.Reporter;

/**
 * Parent Page Object class that contains generic methods
 */
public class BasePage {
    private static final int LOAD_TIMEOUT = 60000;
    private String reportPrefix;

    protected void verifyOpened(SelenideElement element, String pageName) {
        reportPrefix = pageName;
        element.waitUntil(Condition.visible, LOAD_TIMEOUT);
    }

    protected void verifyElementHasText(SelenideElement element, String text) {
        element.shouldHave(Condition.text(text));
    }

    protected void verifyElementHasValue(SelenideElement element, String text) {
        element.shouldHave(Condition.value(text));
    }

    protected void report(String text) {
        Reporter.log("[" + reportPrefix + "] " + text, true);
    }
}
