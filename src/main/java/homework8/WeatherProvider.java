package homework8;

import homework8.enums.Periods;

import java.io.IOException;

/**
 * Java Core. Homework 7
 *
 * @author Vitalii Luzhnov
 * @version 10.03.2022
 */
public interface WeatherProvider {

    void getWeather(Periods periods) throws IOException;

}
