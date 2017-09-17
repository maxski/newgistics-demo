package com.newgistics.tests.api;

import org.testng.Assert;
import org.testng.annotations.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

/**
 * Weather API tests
 */
public class WeatherTest extends APITest {

    @Parameters({"path", "q", "appid"})
    @BeforeTest
    public void setUp(String path, String q, String appid) {
        request
                .basePath(path)
                .param("q", q)
                .param("appid", appid);
    }

    @Parameters({"lon", "lat"})
    @Test
    public void coordinatesEqualsTo(Float lon, Float lat){
        given()
                .spec(request)
                .get()
        .then()
                .log().body()
                .body("coord.lon", is(lon))
                .body("coord.lat", is(lat));
    }

    @Parameters({"temp"})
    @Test
    public void temperatureLessThan(Float temp){
        Float temperature = given()
                .spec(request)
                .get()
        .then()
                .log().body()
        .extract().
                path("main.temp");

        Assert.assertTrue(temperature.compareTo(temp) < 0);
    }
}
