package com.newgistics.tests;

import com.newgistics.pages.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Tests related to Collection Manage functionality
 */

public class CollectionManageTest extends BaseTest {
    LoginFormPage loginPage;
    HeaderPage headerPage;
    LeftMenuPage leftMenuPage;
    CollectionWorkflowPage collectionWorkflowPage;
    ManageWorkflowPage manageWorkflowPage;

    @Parameters({"email", "password", "username"})
    @BeforeTest
    public void openCollectionWorkflows(String email, String password, String username) {
        loginPage = new LoginFormPage();
        headerPage = loginPage.logIn(email, password);
        headerPage.verifyUsername(username);
        leftMenuPage = new LeftMenuPage();
        collectionWorkflowPage = leftMenuPage.openCollectionWorkflows();
    }

    @Parameters({"defaultWorkflow", "workflow"})
    @Test
    public void changeNameAfterAddWorkflow(String defaultWorkflow, String workflow){
        manageWorkflowPage = collectionWorkflowPage.clickAddWorkflow();
        manageWorkflowPage.verifyWorkflowName(defaultWorkflow);
        manageWorkflowPage.clickEditWorkflowName();
        manageWorkflowPage.verifyEditableWorkflowName(defaultWorkflow);
        manageWorkflowPage.setWorkflowName(workflow);
        manageWorkflowPage.clickSaveWorkflowName();
        manageWorkflowPage.verifyWorkflowName(workflow);
    }
}
