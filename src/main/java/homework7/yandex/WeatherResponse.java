package homework7.yandex;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "now",
        "now_dt",
        "info",
        "geo_object",
        "yesterday",
        "fact",
        "forecasts"
})

public class WeatherResponse {

    private float now;
    private String now_dt;
    private Info info;
    private Geo_object geo_object;
    private Yesterday yesterday;
    private Fact fact;
    private Forecast[] forecasts;

    public float getNow() {
        return now;
    }
    public void setNow(float now) {
        this.now = now;
    }

    public String getNow_dt() {
        return now_dt;
    }
    public void setNow_dt(String now_dt) {
        this.now_dt = now_dt;
    }

    public Info getInfo() {
        return info;
    }
    public void setInfo(Info infoObject) {
        this.info = infoObject;
    }

    public Geo_object getGeo_object() {
        return geo_object;
    }
    public void setGeo_object(Geo_object geo_objectObject) {
        this.geo_object = geo_objectObject;
    }

    public Yesterday getYesterday() {
        return yesterday;
    }
    public void setYesterday(Yesterday yesterdayObject) {
        this.yesterday = yesterdayObject;
    }

    public Fact getFact() {
        return fact;
    }
    public void setFact(Fact factObject) {
        this.fact = factObject;
    }

    public Forecast[] getForecasts() { return forecasts; }
    public void setForecasts(Forecast[] forecasts) { this.forecasts = forecasts; }
}
