package com.newgistics.tests.api;

import com.newgistics.pages.LeftMenuPage;
import com.newgistics.pages.LoginFormPage;
import io.restassured.RestAssured;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.path.json.config.JsonPathConfig;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers.*;
import io.restassured.assertion.*;
import org.hamcrest.Matchers.*;
import org.testng.IMethodInstance;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.*;

import static io.restassured.config.JsonConfig.jsonConfig;
import static org.hamcrest.core.Is.is;

/**
 * Created by maxymkr on 9/16/2017.
 */
public class APITest {
    RequestSpecification request;
    ResponseSpecification response;
    String path;

    @Parameters({"baseUri", "basePath"})
    @BeforeSuite
    public void config(String baseUri, String basePath) {
        RestAssured.baseURI = baseUri;
        RestAssured.basePath = basePath;

        request = RestAssured.given()
                .log().uri(); // log only uri

        response = RestAssured.given()
                .then().log().body(); // log only response
    }


    protected void logResponse(){
        Reporter.log("<b>Response</b>");
    }

}
