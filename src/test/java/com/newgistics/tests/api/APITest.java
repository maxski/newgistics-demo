package com.newgistics.tests.api;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.*;


/**
 * Parent API test
 * Responsible to prepare test context before tests
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
