package com.newgistics.tests.ui.desktop;

import com.newgistics.pages.desktop.MenuDesktopPage;
import com.newgistics.tests.ui.UITest;
import org.testng.annotations.Test;

/**
 * Menu tests for UI desktop version
 */
public class MenuDesktopTest extends UITest {

    private MenuDesktopPage page;

    @Test
    public void verifyMenu(){
        page = new MenuDesktopPage();
        page.verifyMenuButtonNotVisible();
        page.verifyMenuElementsVisible();
    }
}
