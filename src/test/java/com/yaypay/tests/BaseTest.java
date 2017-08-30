package com.yaypay.tests;

import com.yaypay.driver.Driver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


/**
 * Parent Test class that responsible to prepare browser/test context before tests
 */
public class BaseTest {

    protected Driver driver = new Driver();

    @BeforeSuite
    public void beforeSuite(){
        driver.init();
        driver.openBaseUrl();
    }


    @AfterSuite
    public void afterSuite(){
        driver.finish();
    }
}

