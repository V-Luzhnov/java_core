package homework8.weatherYandex;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "obs_time",
        "uptime",
        "temp",
        "feels_like",
        "temp_water",
        "icon",
        "condition",
        "cloudness",
        "prec_type",
        "prec_prob",
        "prec_strength",
        "is_thunder",
        "wind_speed",
        "wind_dir",
        "pressure_mm",
        "pressure_pa",
        "humidity",
        "daytime",
        "polar",
        "season",
        "source",
        "accum_prec",
        "soil_moisture",
        "soil_temp",
        "uv_index",
        "wind_gust"
})

public class Fact {

    private float obs_time;
    private float uptime;
    private float temp;
    private float feels_like;
    private float temp_water;
    private String icon;
    private String condition;
    private float cloudness;
    private float prec_type;
    private float prec_prob;
    private float prec_strength;
    private boolean is_thunder;
    private float wind_speed;
    private String wind_dir;
    private float pressure_mm;
    private float pressure_pa;
    private float humidity;
    private String daytime;
    private boolean polar;
    private String season;
    private String source;
    private Accum_prec accum_prec;
    private float soil_moisture;
    private float soil_temp;
    private float uv_index;
    private float wind_gust;

    public float getObs_time() {
        return obs_time;
    }
    public void setObs_time(float obs_time) {
        this.obs_time = obs_time;
    }

    public float getUptime() {
        return uptime;
    }
    public void setUptime(float uptime) {
        this.uptime = uptime;
    }

    public float getTemp() {
        return temp;
    }
    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getFeels_like() {
        return feels_like;
    }
    public void setFeels_like(float feels_like) {
        this.feels_like = feels_like;
    }

    public float getTemp_water() {
        return temp_water;
    }
    public void setTemp_water(float temp_water) {
        this.temp_water = temp_water;
    }

    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCondition() {
        return condition;
    }
    public void setCondition(String condition) {
        this.condition = condition;
    }

    public float getCloudness() {
        return cloudness;
    }
    public void setCloudness(float cloudness) {
        this.cloudness = cloudness;
    }

    public float getPrec_type() {
        return prec_type;
    }
    public void setPrec_type(float prec_type) {
        this.prec_type = prec_type;
    }

    public float getPrec_prob() {
        return prec_prob;
    }
    public void setPrec_prob(float prec_prob) {
        this.prec_prob = prec_prob;
    }

    public float getPrec_strength() {
        return prec_strength;
    }
    public void setPrec_strength(float prec_strength) {
        this.prec_strength = prec_strength;
    }

    public boolean getIs_thunder() {
        return is_thunder;
    }
    public void setIs_thunder(boolean is_thunder) {
        this.is_thunder = is_thunder;
    }

    public float getWind_speed() {
        return wind_speed;
    }
    public void setWind_speed(float wind_speed) {
        this.wind_speed = wind_speed;
    }

    public String getWind_dir() {
        return wind_dir;
    }
    public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }

    public float getPressure_mm() {
        return pressure_mm;
    }
    public void setPressure_mm(float pressure_mm) {
        this.pressure_mm = pressure_mm;
    }

    public float getPressure_pa() {
        return pressure_pa;
    }
    public void setPressure_pa(float pressure_pa) {
        this.pressure_pa = pressure_pa;
    }

    public float getHumidity() {
        return humidity;
    }
    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public String getDaytime() {
        return daytime;
    }
    public void setDaytime(String daytime) {
        this.daytime = daytime;
    }

    public boolean getPolar() {
        return polar;
    }
    public void setPolar(boolean polar) {
        this.polar = polar;
    }

    public String getSeason() {
        return season;
    }
    public void setSeason(String season) {
        this.season = season;
    }

    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }

    public Accum_prec getAccum_prec() {
        return accum_prec;
    }
    public void setAccum_prec(Accum_prec accum_prec) {
        this.accum_prec = accum_prec;
    }

    public float getSoil_moisture() {
        return soil_moisture;
    }
    public void setSoil_moisture(float soil_moisture) {
        this.soil_moisture = soil_moisture;
    }

    public float getSoil_temp() {
        return soil_temp;
    }
    public void setSoil_temp(float soil_temp) {
        this.soil_temp = soil_temp;
    }

    public float getUv_index() {
        return uv_index;
    }
    public void setUv_index(float uv_index) {
        this.uv_index = uv_index;
    }

    public float getWind_gust() {
        return wind_gust;
    }
    public void setWind_gust(float wind_gust) {
        this.wind_gust = wind_gust;
    }
}
