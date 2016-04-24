package com.ibs.driver;

import com.codeborne.selenide.Configuration;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.screenshot;

/**
 * Created by pc on 21.04.2016.
 */
public class BaseTest {
    private static Properties props = getConfigProperties();
    private enum browsers {chrome, firefox};

    @BeforeSuite
    public void beforeSuite(){
        setReportsFolder();
        setBrowser(getConfigProperty("browser"));
    }

    @AfterSuite
    public void afterSuite(){
        close();
    }

    private void setReportsFolder(){
        Configuration.reportsFolder = getConfigProperty("reports.folder");
    }

    protected void setBrowser(String browser){
        Reporter.log("Start browser: " + browser, true);
        if(browser.equals(browsers.chrome.name())){
            setChrome();
        }else{
            setFirefox();
        }
    }

    protected void openUrl(String url){
        Reporter.log("Open url: " + url, true);
        open(url);
    }

    private void setChrome(){
        Configuration.browser=browsers.chrome.name();
        System.setProperty("webdriver.chrome.driver", getConfigProperty("chrome.exec"));
    }

    private void setFirefox(){
        Configuration.browser=browsers.firefox.name();
    }

    public static String getConfigProperty(String key){
        return props.getProperty(key);
    }

    protected static Properties getConfigProperties(){
        Properties props = new Properties();
        InputStream input = null;
        try{
            input = BaseTest.class.getClassLoader().getResourceAsStream("config.properties");
            props.load(input);
        }catch (IOException e){
            e.printStackTrace();
        }
        return props;
    }
}

