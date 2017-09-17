package com.newgistics.pages.desktop;

import com.newgistics.pages.MenuPage;
import static com.codeborne.selenide.Condition.visible;

/**
 * Menu page for desktop version
 */
public class MenuDesktopPage extends MenuPage {

    public void verifyMenuButtonNotVisible() {
        elementIsNot(getMenuButton(), visible);
    }

    public void verifyMenuElementsVisible() {
        elementsIs(getMenuElements(), visible);
    }
}
