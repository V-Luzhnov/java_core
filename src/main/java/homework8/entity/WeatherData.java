package homework8.entity;

/**
 * Java Core. Homework 8
 *
 * @author Vitalii Luzhnov
 * @version 29.03.2022
 */
public class WeatherData {

    private String city;
    private String localDate;
    private String text;
    private Long temperature;

    public WeatherData() {
    }

    public WeatherData(String city, String localDate, String text, Long temperature) {
        this.city = city;
        this.localDate = localDate;
        this.text = text;
        this.temperature = temperature;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getTemperature() {
        return temperature;
    }

    public void setTemperature(Long temperature) {
        this.temperature = temperature;
    }
}
