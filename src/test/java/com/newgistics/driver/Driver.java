package com.newgistics.driver;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.Reporter;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

/**
 * Class is a manager for driver instance
 */
public class Driver {
    private static final String REPORT_PATH = "target/surefire-reports";
    private static final String CHROME_EXEC = "libs/chromedriver.exe";


    public void init() {
        setReportsFolder();
        setBrowser();
    }

    public void openUrl(String url) {
        Reporter.log("Open url: " + url, true);
        open(url);
    }

    public void openBaseUrl() {
        openUrl(System.getProperty("selenide.baseUrl"));
    }

    public void finish() {
        close();
    }

    private void setReportsFolder() {
        Configuration.reportsFolder = REPORT_PATH;
    }

    private void setBrowser() {
        Reporter.log("Start browser: " + Configuration.browser, true);
        if (WebDriverRunner.isChrome()) {
            System.setProperty("webdriver.chrome.driver", CHROME_EXEC);
            System.setProperty("chromeoptions.args","--disable-extensions,--disable-infobars");
        }
    }
}

