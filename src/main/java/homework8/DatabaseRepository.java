package homework8;

import homework8.entity.WeatherData;

import java.io.IOException;

import java.sql.SQLException;

import java.util.List;

/**
 * Java Core. Homework 8
 *
 * @author Vitalii Luzhnov
 * @version 29.03.2022
 */
// Репозиторий для работы
public interface DatabaseRepository {

    boolean saveWeatherData(WeatherData weatherData) throws SQLException;

    List<WeatherData> getAllSavedData() throws IOException, SQLException;
}
