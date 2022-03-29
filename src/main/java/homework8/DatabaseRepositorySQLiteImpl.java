package homework8;

import homework8.entity.WeatherData;

import java.io.IOException;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Java Core. Homework 8
 *
 * @author Vitalii Luzhnov
 * @version 29.03.2022
 */
public class DatabaseRepositorySQLiteImpl implements DatabaseRepository {

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    String filename = null;
    String createTableQuery = "CREATE TABLE IF NOT EXISTS weather (\n" +
        "id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
        "city TEXT NOT NULL,\n" +
        "date_time TEXT NOT NULL,\n" +
        "weather_text TEXT NOT NULL,\n" +
        "temperature REAL NOT NULL\n" +
        ");";
    String insertWeatherQuery = "INSERT INTO weather (city, date_time, weather_text, temperature) VALUES (?,?,?,?)";

    public DatabaseRepositorySQLiteImpl() {
        filename = ApplicationGlobalState.getInstance().getDbFileName();
    }

    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:" + filename);
        return connection;
    }

    public Statement getStatement() throws SQLException {
        Statement statement = getConnection().createStatement();
        return statement;
    }

    public PreparedStatement getPreparedStatement() throws SQLException{
        PreparedStatement preparedStatement = getConnection().prepareStatement(insertWeatherQuery);
        return preparedStatement;
    }
    public void createTableIfNotExists() {
        try (Connection connection = getConnection()) {
            connection.createStatement().execute(createTableQuery);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
//    public void createTableIfNotExists() {
//        try (Statement statement = getStatement()) {
//            statement.executeUpdate(createTableQuery);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }

    @Override
    public boolean saveWeatherData(WeatherData weatherData) throws SQLException {
        try (Connection connection = getConnection();
        PreparedStatement saveWeather = connection.prepareStatement(insertWeatherQuery)) {
            saveWeather.setString(1, weatherData.getCity());
            saveWeather.setString(2, weatherData.getLocalDate());
            saveWeather.setString(3, weatherData.getText());
            saveWeather.setDouble(4, weatherData.getTemperature());
            return saveWeather.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new SQLException("Failure on saving weather object");
    }

//    @Override
//    public List<WeatherData> getAllSavedData() throws IOException {
//        throw new IOException("Not implemented exception");
//    }

    @Override
    public List<WeatherData> getAllSavedData() throws SQLException {
        ResultSet resultSet = getConnection().createStatement().executeQuery("SELECT * FROM weather");
        List<WeatherData> weatherDataList = new ArrayList<WeatherData>();
        while (resultSet.next()) {
            weatherDataList.add(new WeatherData(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getDouble(5)));
        }
        return weatherDataList;
    }

    public void closeConnection (){
        try {
            getConnection().close();
            getStatement().close();
            getPreparedStatement().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
