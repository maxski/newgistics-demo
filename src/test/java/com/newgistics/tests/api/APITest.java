package com.newgistics.tests.api;

import com.newgistics.pages.LeftMenuPage;
import com.newgistics.pages.LoginFormPage;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.LogConfig;
import io.restassured.filter.log.LogDetail;
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

    @Parameters({"baseUri"})
    @BeforeSuite
    public void config(String baseUri) {
        request = RestAssured.given()
                .baseUri(baseUri) // base test
                .log().uri(); // log only uri
    }
}
