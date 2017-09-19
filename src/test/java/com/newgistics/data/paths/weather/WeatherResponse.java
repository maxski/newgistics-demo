package com.newgistics.data.paths.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Weather response
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
    public Coord coord;
    public class Coord {
        public float lon;
        public float lat;
    }
    public Main main;
    public class Main {
        public float temp;
        public float pressure;
        public float humidity;
        public float temp_min;
        public float temp_max;
    }
}
