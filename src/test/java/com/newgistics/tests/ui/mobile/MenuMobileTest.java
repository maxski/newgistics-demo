package com.newgistics.tests.ui.mobile;

import com.newgistics.pages.mobile.MenuMobilePage;
import com.newgistics.tests.ui.UITest;
import org.testng.annotations.Test;

/**
 * Menu tests for UI mobile version
 */
public class MenuMobileTest extends UITest {

    MenuMobilePage page;

    @Test
    public void verifyMenu() {
        page = new MenuMobilePage();
        page.verifyMenuButtonVisible();
    }
}
