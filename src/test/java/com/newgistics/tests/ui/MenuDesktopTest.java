package com.newgistics.tests.ui;

import com.newgistics.data.pages.MenuPage;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Condition.visible;

/**
 * Menu tests for UI desktop version
 */
public class MenuDesktopTest extends UITest {

    MenuPage page;

    @Test
    public void verifyMenu(){
        page = new MenuPage();
        page.elementIsNot(page.getMenuButton(), visible);
        page.elementsIs(page.getMenuElements(), visible);
    }
}
