package com.newgistics.tests.ui;

import com.newgistics.driver.Chrome;
import org.testng.annotations.*;

/**
 * Parent UI test
 * Responsible to prepare browser/test context before tests
 */
public class UITest {

    protected Chrome browser = new Chrome();

    @BeforeTest
    @Parameters({"url", "width", "height", "user-agent"})
    public void setUp(String url, String width, String height, @Optional String userAgent) {
        browser.setReportsFolder();
        browser.setMode(userAgent);
        browser.setSize(width, height);
        browser.openUrl(url);
    }


    @AfterTest
    public void tearDown(){
        browser.finish();
    }
}

