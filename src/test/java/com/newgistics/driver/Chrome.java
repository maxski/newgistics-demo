package com.newgistics.driver;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import java.util.HashMap;
import java.util.Map;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.CHROME;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

/**
 * Class is a manager for Chrome driver instance
 */
public class Chrome {
    private static final String REPORT_PATH = "target/surefire-reports";
    private static final String CHROME_EXEC_PROPERTY = "webdriver.chrome.driver";
    private static final String CHROME_EXEC_VALUE = "libs/chromedriver.exe";
    private static final String CHROME_OPTIONS_PROPERTY = "chromeoptions.args";
    private static final String CHROME_OPTIONS_VALUE = "--disable-extensions,--disable-infobars";

    public void openUrl(String url) {
        Reporter.log("Open url: " + url, true);
        open(url);
    }

    public void finish() {
        close();
    }

    public void setSize(String size) {
        Configuration.browserSize = size;
    }

    public void setReportsFolder() {
        Configuration.reportsFolder = REPORT_PATH;
    }

    public void setMode(String userAgent) {
        Configuration.browser = CHROME;
        System.setProperty(CHROME_EXEC_PROPERTY, CHROME_EXEC_VALUE);
        System.setProperty(CHROME_OPTIONS_PROPERTY, CHROME_OPTIONS_VALUE);
        //if (userAgent != null && !userAgent.isEmpty()) {
            //Reporter.log("User agent: " + userAgent);
            //String options = CHROME_OPTIONS_VALUE + ",--user-agent=\"" + userAgent + "\"";
            //initMobileChrome(userAgent);
            //System.setProperty(CHROME_OPTIONS_PROPERTY, options);
        //}
    }

/*    private void initMobileChrome(String userAgent) {
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("userAgent", userAgent);
        options.setExperimentalOption("mobileEmulation", mobileEmulation);
        options.addArguments(CHROME_OPTIONS_VALUE);
        caps.setCapability(ChromeOptions.CAPABILITY, options);
        setWebDriver(new ChromeDriver(caps));
    }*/

}

