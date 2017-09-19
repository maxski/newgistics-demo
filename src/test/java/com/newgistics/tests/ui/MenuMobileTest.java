package com.newgistics.tests.ui;

import com.newgistics.data.pages.MenuPage;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Condition.visible;

/**
 * Menu tests for UI mobile version
 */
public class MenuMobileTest extends UITest {

    MenuPage page;

    @Test
    public void verifyMenu() {
        page = new MenuPage();
        page.elementIs(page.getMenuButton(), visible);
    }
}
