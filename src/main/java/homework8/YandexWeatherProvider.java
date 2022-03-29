package homework8;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import homework8.enums.Periods;
import homework8.weatherYandex.Forecast;
import homework8.weatherYandex.WeatherResponse;
import homework8.entity.WeatherData;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;

import java.sql.SQLException;

import java.util.Objects;
import java.util.Properties;
import java.util.List;

/**
 * Java Core. Homework 8
 *
 * @author Vitalii Luzhnov
 * @version 29.03.2022
 */
public class YandexWeatherProvider implements WeatherProvider {

    static Properties prop = new Properties();

    private static final String API_KEY = ApplicationGlobalState.getInstance().getApiKey();

    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    private DatabaseRepositorySQLiteImpl databaseRepositorySQLite = new DatabaseRepositorySQLiteImpl();

    @Override
    public void getWeather(Periods periods) throws IOException, SQLException  {

        loadProperties();

        if (periods.equals(Periods.NOW) || periods.equals(Periods.FIVE_DAYS)) {

            String[] valLatLon = detectLatLon();
            String latValue = valLatLon[0];
            String lonValue = valLatLon[1];

            HttpUrl url;
            url = new HttpUrl.Builder()
                    .scheme(prop.getProperty("SCHEME"))
                    .host(prop.getProperty("BASE_HOST"))
                    .addPathSegment(prop.getProperty("API_VERSION"))
                    .addPathSegment(prop.getProperty("FORECAST"))
                    .addQueryParameter("lat", latValue)
                    .addQueryParameter("lon", lonValue)
                    .addQueryParameter("lang", prop.getProperty("LANG"))
                    .addQueryParameter("limit", periods.equals(Periods.NOW)?"1":prop.getProperty("LIMIT"))
                    .build();

            Request request = new Request.Builder()
                    .url(url)
                    .addHeader("X-Yandex-API-Key", API_KEY)
                    .build();

            String responseList = Objects.requireNonNull(client.newCall(request).execute().body()).string();

            StringReader reader = new StringReader(responseList);

            WeatherResponse weatherResponse = objectMapper.readValue(reader, WeatherResponse.class);

            String city = objectMapper
                    .readTree(responseList)
                    .at("/geo_object/locality/name")
                    .asText();

            for (Forecast forecast : weatherResponse.getForecasts()) {

                String valveRes = "В городе " +
                        city +
                        (periods.equals(Periods.NOW) ? " сегодня (" : " на дату ") +
                        forecast.getDate() +
                        (periods.equals(Periods.NOW) ? ") " : " ожидается ") +
                        forecast.getParts().getDay_short().getCondition() +
                        ", температура " +
                        forecast.getParts().getDay_short().getTemp();
                System.out.println(valveRes);

                WeatherData weatherData = new WeatherData(
                        city,
                        forecast.getDate(),
                        forecast.getParts().getDay_short().getCondition(),
                        forecast.getParts().getDay_short().getTemp()
                );

                databaseRepositorySQLite.createTableIfNotExists();
                databaseRepositorySQLite.saveWeatherData(weatherData);
            }
        }

        if (periods.equals(Periods.BASE_DATE)) {
            getDataFromDbTillDate();
        }

        if (periods.equals(Periods.BASE)) {
            getAllFromDb();
        }

        if (periods.equals(Periods.CLEAR)) {
            databaseRepositorySQLite.performDropTable();
            System.out.println("База данных очещена");
        }

        if (periods.equals(Periods.CLOSE)) {
            databaseRepositorySQLite.closeConnection();
        }
    }

    @Override
    public List<WeatherData> getAllFromDb() throws SQLException {
        List<WeatherData> weatherDataList = databaseRepositorySQLite.getAllSavedData();
        printlnResult(weatherDataList);
        return weatherDataList;
    }

    public void getDataFromDbTillDate() throws SQLException {
        String selectedDate = ApplicationGlobalState.getInstance().getSelectedDate();
        List<WeatherData> weatherDataList = databaseRepositorySQLite.getDataTillDate(selectedDate);
        printlnResult(weatherDataList);
    }

    public void printlnResult(List<WeatherData> weatherDataList) {
        if (weatherDataList.size() == 0){
            System.out.println("Данные отсутствуют в базе");
        }else {
            for (WeatherData weatherData : weatherDataList) {
                String valveRes = "В городе " +
                        weatherData.getCity() +
                        " на дату " +
                        weatherData.getLocalDate() +
                        " ожидается " +
                        weatherData.getText() +
                        ", температура " +
                        weatherData.getTemperature();
                System.out.println(valveRes);
            }
        }
    }

    public String[] detectLatLon() throws IOException {

        OkHttpClient client = new OkHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();

        String selectedCity = ApplicationGlobalState.getInstance().getSelectedCity();
        String apiKeyForCity = ApplicationGlobalState.getInstance().getApiKeyForCity();

        System.out.println("Поиск города " + selectedCity + "...");

        HttpUrl detectLocationURL = new HttpUrl.Builder()
                .scheme("https")
                .host("open.mapquestapi.com")
                .addPathSegment("geocoding")
                .addPathSegment("v1")
                .addPathSegment("address")
                .addQueryParameter("key", apiKeyForCity)
                .addQueryParameter("location", selectedCity)
                .build();

        Request request = new Request.Builder()
                .url(detectLocationURL)
                .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            throw new IOException("Невозможно прочесть информацию о городе. " +
                    "Код ответа сервера = " + response.code() + " тело ответа = " + Objects.requireNonNull(response.body()).string());
        }

        String jsonResponse = Objects.requireNonNull(response.body()).string();

        if (objectMapper.readTree(jsonResponse).size() == 0) {
            throw new IOException("Server returns 0 cities");
        }

        for (JsonNode res : objectMapper.readTree(jsonResponse).at("/results")) {
            for (JsonNode loc : res.at("/locations")) {
                String lat = loc.at("/latLng/lat").asText();
                String lon = loc.at("/latLng/lng").asText();
                System.out.println("Город " + selectedCity + " найден на широте " + lat + " и долготе " + lon);
                return new String[]{lat, lon};
            }
        }

        throw new IOException("Server returns 0 cities");
    }

    private static void loadProperties() throws IOException {
        try(FileInputStream configFile = new FileInputStream("src/main/resources/weatherYandex.properties")){
            prop.load(configFile);
        }
    }

}
