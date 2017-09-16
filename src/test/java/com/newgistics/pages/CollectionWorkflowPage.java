package com.newgistics.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Page Object class describes collection process page:
 * https://www.demo.yaypay.com/app/my/collection-process
 */
public class CollectionWorkflowPage extends BasePage {
    public CollectionWorkflowPage() {
        verifyOpened(getWorkflows(), getClass().getSimpleName());
    }

    private SelenideElement getWorkflows() {
        return $(By.xpath("//div[@class='coll-content is-active js-templates-block']"));
    }

    private SelenideElement getAddWorkflow() {
        return $(By.xpath("//span[.='New Workflow']"));
    }

    public ManageWorkflowPage clickAddWorkflow() {
        report("Click Add Workflow");
        getAddWorkflow().click();
        return new ManageWorkflowPage();
    }


}
