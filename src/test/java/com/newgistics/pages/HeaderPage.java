package com.newgistics.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

/**
 * Page Object class describes header panel.
 * Header panel is actual for all logged in user pages
 */
public class HeaderPage extends BasePage {

    public HeaderPage() {
        verifyOpened(getUsername(), getClass().getSimpleName());
    }

    private SelenideElement getUsername(){
        return $(".user-name");
    }

    public void verifyUsername(String username) {
        report("Verify username contains text: " + username);
        verifyElementHasText(getUsername(), username);
    }
}
