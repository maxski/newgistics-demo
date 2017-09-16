package com.newgistics.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Page Object class describes collection manage page:
 * https://www.demo.yaypay.com/app/my/collection-process/manage
 */
public class ManageWorkflowPage extends BasePage {

    public ManageWorkflowPage() {
        verifyOpened(getWorkflowName(), getClass().getSimpleName());
    }

    private SelenideElement getWorkflowNameParent() {
        return $(By.xpath("//div[@class='template-name js-template-name']"));
    }

    private SelenideElement getWorkflowName() {
        return getWorkflowNameParent().$("p");
    }

    private SelenideElement getEditWorkflowName() {
        return getWorkflowNameParent().$("i");
    }

    private SelenideElement getEditableWorkflowName() {
        return getWorkflowNameParent().$("input");
    }

    private SelenideElement getSaveWorkflowName() {
        return getWorkflowNameParent().$("i:last-child");
    }

    public void verifyWorkflowName(String name) {
        report("Verify workflow name contains text: " + name);
        verifyElementHasText(getWorkflowName(), name);
    }

    public void clickEditWorkflowName() {
        report("Click Edit workflow name");
        getEditWorkflowName().click();
    }

    public void verifyEditableWorkflowName(String name) {
        report("Verify editable workflow name contains value: " + name);
        verifyElementHasValue(getEditableWorkflowName(), name);
    }

    public void setWorkflowName(String name) {
        report("Set workflow name: " + name);
        getEditableWorkflowName().setValue(name);
    }

    public void clickSaveWorkflowName() {
        report("Click Save workflow name");
        getSaveWorkflowName().click();
    }

}
