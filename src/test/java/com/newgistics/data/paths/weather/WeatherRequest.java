package com.newgistics.data.paths.weather;

/**
 * Weather request
 */
public class WeatherRequest {
    private static final String PATH = "/weather?q=%s&appid=%s";
    private String q;
    private String appid;

    public WeatherRequest(String q, String appid) {
        this.q = q;
        this.appid = appid;
    }

    public String getPath() {
        return String.format(PATH, q, appid);
    }



}
