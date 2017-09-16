package com.newgistics.tests.api;

import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

/**
 * Created by maxymkr on 9/16/2017.
 */
public class WeatherTest extends APITest {

    @Parameters({"path", "q", "appid"})
    @BeforeClass
    public void setUp(String path, String q, String appid) {
        this.path = path;
        request.param("q", q)
                .param("appid", appid);
    }

    @Parameters({"lon", "lat"})
    @Test
    public void coordinatesEqualsTo(Float lon, Float lat){
        response.given().
                spec(request).
                get(path).
        then().
                body("coord.lon", is(lon)).
                body("coord.lat", is(lat));
    }

    @Parameters({"temp"})
    @Test
    public void temperatureLessThan(Float temp){
        Float temperature = response.given().
                spec(request).
                get(path).
        then().
        extract().
                path("main.temp");
        Assert.assertTrue(temperature.compareTo(temp)< 0);
    }
}
