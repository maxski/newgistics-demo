package com.newgistics.tests.api;

import com.newgistics.data.paths.weather.WeatherRequest;
import com.newgistics.data.paths.weather.WeatherResponse;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

/*
 * Weather API tests
 */
public class WeatherTest extends APITest {

    WeatherResponse response;

    @BeforeTest
    @Parameters({"q", "appid"})
    public void setUp(String q, String appid) {
        WeatherRequest request = new WeatherRequest(q, appid);
        response = getResponse(defaultSpec, WeatherResponse.class, request.getPath());
    }

    @Test
    @Parameters({"lon", "lat"})
    public void coordinatesEqualsTo(Float lon, Float lat) {
        assertThat(response.coord.lon).isEqualTo(lon);
        assertThat(response.coord.lat).isEqualTo(lat);
    }

    @Test
    @Parameters({"temp"})
    public void temperatureLessThan(Float temp) {
        assertThat(response.main.temp).isLessThan(temp);
    }
}
