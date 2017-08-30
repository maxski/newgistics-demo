package com.yaypay.pages;

import com.codeborne.selenide.SelenideElement;
import org.testng.Reporter;

import static com.codeborne.selenide.Selenide.$;

/**
 * Page Object class describes login form page:
 * https://www.demo.yaypay.com/app/login
 */
public class LoginFormPage extends BasePage {

    public LoginFormPage() {
        verifyOpened(getSingIn(), getClass().getSimpleName());
    }

    private SelenideElement getEmail(){
        return $("#email");
    }

    private SelenideElement getPassword() {
        return $("#login-pass");
    }

    private SelenideElement getSingIn() {
        return $("button[type=submit]");
    }


    public void setEmail(String email) {
        report("Set email: " + email);
        getEmail().setValue(email);
    }

    public void setPassword(String password) {
        report("Set password: " + password);
        getPassword().setValue(password);
    }

    public void clickSingIn() {
        report("Click Sing In");
        getSingIn().click();
    }

    public HeaderPage logIn(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickSingIn();
        return new HeaderPage();
    }
}
