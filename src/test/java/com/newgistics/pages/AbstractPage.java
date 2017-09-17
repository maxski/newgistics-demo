package com.newgistics.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.testng.Reporter;
import static com.codeborne.selenide.Condition.visible;

/**
 * Parent page
 * Represents functionality shared across all pages
 */
public abstract class AbstractPage {
    private static final int LOAD_TIMEOUT = 60000;
    private static final String VERIFY_LOG = "Verify element%s %s%s %s [%s]";

    protected void verifyOpened(SelenideElement element) {
        elementIs(element, visible, LOAD_TIMEOUT);
    }

    protected void elementIs(SelenideElement element, Condition condition, long timeout) {
        log(false, false, condition, "in " + timeout + "ms timeout"
                , element.getSearchCriteria());
        element.waitUntil(condition, timeout);
    }

    protected void elementIs(SelenideElement element, Condition condition) {
        log(false, false, condition, "", element.getSearchCriteria());
        element.should(condition);
    }

    protected void elementIsNot(SelenideElement element, Condition condition) {
        log(false, true, condition, "", element.getSearchCriteria());
        element.shouldNot(condition);
    }

    protected void elementsIs(ElementsCollection collection, Condition condition) {
        String search = collection.first().getSearchCriteria();
        log(true, false, condition, "", search.substring(0, search.length() - 3));
        collection.filter(condition).shouldHaveSize(collection.size());
    }

    protected void log(boolean s, boolean not, Condition condition, String text, String locator) {
        log(String.format(VERIFY_LOG, s ? "s" : "", not ? "not " : "", condition.toString(), text, locator));
    }

    protected void log(String text) {
        Reporter.log(text, true);
    }
}
