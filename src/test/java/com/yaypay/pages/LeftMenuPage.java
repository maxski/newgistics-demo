package com.yaypay.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Page Object class describes left menu panel.
 * Left menu panel is actual for all logged in user pages
 */
public class LeftMenuPage extends BasePage {

    public LeftMenuPage() {
        verifyOpened(getLeftMenu(), getClass().getSimpleName());
    }

    private SelenideElement getLeftMenu() {
        return $(".left-menu");
    }

    private SelenideElement getCollectionWorkflows() {
        return $(By.xpath("//p[.='Collection Workflows']"));
    }

    public CollectionWorkflowPage openCollectionWorkflows() {
        report("Click Collection Workflows menu");
        getCollectionWorkflows().click();
        return new CollectionWorkflowPage();
    }

}
