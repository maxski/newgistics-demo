package com.newgistics.driver;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.testng.annotations.Report;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import java.util.HashMap;
import java.util.Map;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.CHROME;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

/**
 * Class is a manager for Chrome driver instance
 */
public class Chrome {
    private static final String REPORT_PATH = "target/surefire-reports";
    private static final String CHROME_EXEC_PROPERTY = "webdriver.chrome.driver";
    private static final String CHROME_EXEC_VALUE = "libs/chromedriver.exe";
    private static final String CHROME_OPTS_PROPERTY = "chromeoptions.args";
    private static final String CHROME_OPTS_DISABLE_EXTENSIONS = "--disable-extensions";
    private static final String CHROME_OPTS_DISABLE_INFOBAR = "--disable-infobars";
    private static final String CHROME_OPTS_MOBILE_EMULATION = "mobileEmulation";
    private static final String CHROME_OPTS_USER_AGENT = "userAgent";

    public void openUrl(String url) {
        Reporter.log("Open url: " + url, true);
        open(url);
    }

    public void finish() {
        close();
    }

    public void setSize(String width, String height) {
        Reporter.log("Set window size: " + width + "x" + height, true);
        Dimension dimension = new Dimension(Integer.valueOf(width), Integer.valueOf(height));
        getWebDriver().manage().window().setSize(dimension);
    }

    public void setReportsFolder() {
        Configuration.reportsFolder = REPORT_PATH;
    }

    public void setMode(String userAgent) {
        Configuration.browser = CHROME;
        System.setProperty(CHROME_EXEC_PROPERTY, CHROME_EXEC_VALUE);
        setDriver(userAgent);
    }

    private void setDriver(String userAgent) {
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        if (userAgent != null && !userAgent.isEmpty()) {
            Map<String, Object> mobileEmulation = new HashMap<>();
            mobileEmulation.put(CHROME_OPTS_USER_AGENT, userAgent);
            options.setExperimentalOption(CHROME_OPTS_MOBILE_EMULATION, mobileEmulation);
        }
        options.addArguments(CHROME_OPTS_DISABLE_EXTENSIONS, CHROME_OPTS_DISABLE_INFOBAR);
        caps.setCapability(ChromeOptions.CAPABILITY, options);
        setWebDriver(new ChromeDriver(caps));
    }

}

