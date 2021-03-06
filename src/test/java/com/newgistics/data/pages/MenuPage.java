package com.newgistics.data.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Menu page
 */
public class MenuPage extends Page {

    public MenuPage() {
        verifyOpened(getParentElement());
    }

    public SelenideElement getParentElement() {
        return $("#navigation");
    }

    public SelenideElement getMenuButton(){
        return $(".menu-open");
    }

    public ElementsCollection getMenuElements() {
        return $$("#main-nav > li");
    }
}
