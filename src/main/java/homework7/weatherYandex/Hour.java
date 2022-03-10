package homework7.weatherYandex;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "hour",
        "hour_ts",
        "temp",
        "feels_like",
        "temp_water",
        "icon",
        "condition",
        "prec_type",
        "prec_strength",
        "is_thunder",
        "wind_dir",
        "wind_speed",
        "wind_gust",
        "pressure_mm",
        "pressure_pa",
        "humidity",
        "uv_index",
        "soil_temp",
        "soil_moisture",
        "prec_mm",
        "prec_period",
        "prec_prob"
})

public class Hour {

    private String hour;
    private long hour_ts;
    private long temp;
    private long feels_like;
    private long temp_water;
    private String icon;
    private String condition;
    private double cloudness;
    private long prec_type;
    private long prec_strength;
    private boolean is_thunder;
    private String wind_dir;
    private double wind_speed;
    private double wind_gust;
    private long pressure_mm;
    private long pressure_pa;
    private long humidity;
    private long uv_index;
    private long soil_temp;
    private double soil_moisture;
    private long prec_mm;
    private long prec_period;
    private long prec_prob;

    public String getHour() { return hour; }
    public void setHour(String value) { this.hour = value; }

    public long getHour_ts() { return hour_ts; }
    public void setHour_ts(long value) { this.hour_ts = value; }

    public long getTemp() { return temp; }
    public void setTemp(long value) { this.temp = value; }

    public long getFeels_like() { return feels_like; }
    public void setFeels_like(long value) { this.feels_like = value; }

    public long getTemp_water() { return temp_water; }
    public void setTemp_water(long value) { this.temp_water = value; }

    public String getIcon() { return icon; }
    public void setIcon(String value) { this.icon = value; }

    public String getCondition() { return condition; }
    public void setCondition(String value) { this.condition = value; }

    public double getCloudness() { return cloudness; }
    public void setCloudness(double value) { this.cloudness = value; }

    public long getPrec_type() { return prec_type; }
    public void setPrec_type(long value) { this.prec_type = value; }

    public long getPrec_strength() { return prec_strength; }
    public void setPrec_strength(long value) { this.prec_strength = value; }

    public boolean getIs_thunder() { return is_thunder; }
    public void setIs_thunder(boolean value) { this.is_thunder = value; }

    public String getWind_dir() { return wind_dir; }
    public void setWind_dir(String value) { this.wind_dir = value; }

    public double getWind_speed() { return wind_speed; }
    public void setWind_speed(double value) { this.wind_speed = value; }

    public double getWind_gust() { return wind_gust; }
    public void setWind_gust(double value) { this.wind_gust = value; }

    public long getPressure_mm() { return pressure_mm; }
    public void setPressure_mm(long value) { this.pressure_mm = value; }

    public long getPressure_pa() { return pressure_pa; }
    public void setPressure_pa(long value) { this.pressure_pa = value; }

    public long getHumidity() { return humidity; }
    public void setHumidity(long value) { this.humidity = value; }

    public long getUv_index() { return uv_index; }
    public void setUv_index(long value) { this.uv_index = value; }

    public long getSoil_temp() { return soil_temp; }
    public void setSoil_temp(long value) { this.soil_temp = value; }

    public double getSoil_moisture() { return soil_moisture; }
    public void setSoil_moisture(double value) { this.soil_moisture = value; }

    public long getPrec_mm() { return prec_mm; }
    public void setPrec_mm(long value) { this.prec_mm = value; }

    public long getPrec_period() { return prec_period; }
    public void setPrec_period(long value) { this.prec_period = value; }

    public long getPrec_prob() { return prec_prob; }
    public void setPrec_prob(long value) { this.prec_prob = value; }
}
