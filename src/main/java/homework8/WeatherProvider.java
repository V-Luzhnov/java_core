package homework8;

import homework8.entity.WeatherData;
import homework8.enums.Periods;

import java.io.IOException;

import java.sql.SQLException;

import java.util.List;

/**
 * Java Core. Homework 8
 *
 * @author Vitalii Luzhnov
 * @version 29.03.2022
 */
public interface WeatherProvider {

    void getWeather(Periods periods) throws IOException, SQLException;

    List<WeatherData> getAllFromDb() throws IOException, SQLException;
}
