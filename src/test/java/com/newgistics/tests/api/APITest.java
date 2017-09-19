package com.newgistics.tests.api;

import io.restassured.specification.RequestSpecification;
import org.testng.annotations.*;

import static io.restassured.RestAssured.given;


/**
 * Parent API test
 * Responsible to prepare test context before tests
 */
public class APITest {

    RequestSpecification defaultSpec;

    @Parameters({"baseUri", "basePath"})
    @BeforeSuite
    public void createSpec(String baseUri, String basePath) {
        defaultSpec = given()
                .baseUri(baseUri)
                .basePath(basePath)
                .log().uri(); // log only uri
    }

    /**
     * Returns response of the given type
     *
     * @param spec, RequestSpecification, specification used to create request
     * @param responseClass, Class, class used to parse response
     * @param path, String, path used to make request
     * @return Object of giving class type
     */
    protected <T> T getResponse(RequestSpecification spec, Class<T> responseClass, String path) {
        return given()
                .spec(spec)
                .get(path)
            .then()
                .log().body() // log only body
                .statusCode(200)
            .extract()
                .as(responseClass);
    }
}
