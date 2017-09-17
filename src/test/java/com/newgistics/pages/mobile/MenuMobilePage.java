package com.newgistics.pages.mobile;

import com.newgistics.pages.MenuPage;
import static com.codeborne.selenide.Condition.visible;

/**
 * Menu page for mobile version
 */
public class MenuMobilePage extends MenuPage {

    public void verifyMenuButtonVisible() {
        elementIs(getMenuButton(), visible);
    }

}
