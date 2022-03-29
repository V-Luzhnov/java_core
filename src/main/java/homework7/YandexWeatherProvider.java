package homework7;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import homework7.enums.Periods;
import homework7.weatherYandex.Forecast;
import homework7.weatherYandex.WeatherResponse;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.Objects;
import java.util.Properties;

/**
 * Java Core. Homework 7
 *
 * @author Vitalii Luzhnov
 * @version 10.03.2022
 */
public class YandexWeatherProvider implements WeatherProvider {

    static Properties prop = new Properties();

    private static final String API_KEY = ApplicationGlobalState.getInstance().getApiKey();

    public void getWeather(Periods periods) throws IOException {

        loadProperties();

        OkHttpClient client = new OkHttpClient();
        ObjectMapper mapper = new ObjectMapper();

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

        String jsonResponse = Objects.requireNonNull(client.newCall(request).execute().body()).string();
//        System.out.println(jsonResponse);

        StringReader reader = new StringReader(jsonResponse);

        WeatherResponse weatherResponse = mapper.readValue(reader, WeatherResponse.class);

        String city = mapper
                .readTree(jsonResponse)
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
