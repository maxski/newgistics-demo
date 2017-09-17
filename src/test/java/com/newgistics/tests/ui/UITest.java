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
    @Parameters({"url", "size", "user-agent"})
    public void setUp(String url, String size, @Optional String userAgent) {
        browser.setReportsFolder();
        browser.setSize(size);
        browser.setMode(userAgent);
        browser.openUrl(url);
    }


    @AfterTest
    public void tearDown(){
        browser.finish();
    }
}

