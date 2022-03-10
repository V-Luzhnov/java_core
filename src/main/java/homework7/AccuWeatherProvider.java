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
import java.lang.reflect.Array;
import java.util.Objects;
import java.util.Properties;

public class AccuWeatherProvider implements WeatherProvider {

    static Properties prop = new Properties();

    private static final String BASE_HOST = "api.weather.yandex.ru";
    private static final String API_VERSION = "v2";
    private static final String FORECAST = "forecast";
    private static final String LANG = "ru_RU";
    private static final String API_KEY = ApplicationGlobalState.getInstance().getApiKey();

//    private final OkHttpClient client = new OkHttpClient();
//    private final ObjectMapper objectMapper = new ObjectMapper();


    public void getWeather(Periods periods) throws IOException {

        loadProperties();
        OkHttpClient client = new OkHttpClient();
        ObjectMapper mapper = new ObjectMapper();

        String[] valLatLon = detectLatLon();
        String latValue = valLatLon[0];
        String lonValue = valLatLon[1];

        HttpUrl url = null;

        if (periods.equals(Periods.NOW)) {
            url = new HttpUrl.Builder()
                    .scheme("https")
                    .host(BASE_HOST)
                    .addPathSegment(API_VERSION)
                    .addPathSegment(FORECAST)
                    .addQueryParameter("lat", latValue)
                    .addQueryParameter("lon", lonValue)
                    .addQueryParameter("lang", LANG)
                    .addQueryParameter("limit", "1")
                    .build();
        }

        if (periods.equals(Periods.FIVE_DAYS)) {
            url = new HttpUrl.Builder()
                    .scheme("https")
                    .host(BASE_HOST)
                    .addPathSegment(API_VERSION)
                    .addPathSegment(FORECAST)
                    .addQueryParameter("lat", latValue)
                    .addQueryParameter("lon", lonValue)
                    .addQueryParameter("lang", LANG)
                    .addQueryParameter("limit", "5")
                    .build();
        }

        assert url != null;
        // Указание заголовка
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
            if (periods.equals(Periods.NOW)) {
                System.out.println(
                        "В городе " + city +
//                        "В городе " + ApplicationGlobalState.getInstance().getSelectedCity() +
                        " сегодня (" + forecast.getDate() +
                        ") " + forecast.getParts().getDay_short().getCondition() +
                        ", температура " + forecast.getParts().getDay_short().getTemp()
                );
            }
            if (periods.equals(Periods.FIVE_DAYS)) {
                System.out.println(
                    "В городе " + city +
//                    "В городе " + ApplicationGlobalState.getInstance().getSelectedCity() +
                    " на дату " + forecast.getDate() +
                   " ожидается " + forecast.getParts().getDay_short().getCondition() +
                   ", температура " + forecast.getParts().getDay_short().getTemp()
                );
            }
        }
    }

    public String[] detectLatLon() throws IOException {

        OkHttpClient client = new OkHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();

        String selectedCity = ApplicationGlobalState.getInstance().getSelectedCity();
        String apiKeyForCity = ApplicationGlobalState.getInstance().getApiKeyForCity();

        HttpUrl detectLocationURL = new HttpUrl.Builder()
                .scheme("https")
                .host("open.mapquestapi.com")
                .addPathSegment("geocoding")
                .addPathSegment("v1")
                .addPathSegment("address")
                .addQueryParameter("key", apiKeyForCity)
                .addQueryParameter("location", selectedCity)
                .build();

        // Указание заголовка
        Request request = new Request.Builder()
                .url(detectLocationURL)
                .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            throw new IOException("Невозможно прочесть информацию о городе. " +
                "Код ответа сервера = " + response.code() + " тело ответа = " + Objects.requireNonNull(response.body()).string());
        }
        String jsonResponse = Objects.requireNonNull(response.body()).string();
//        System.out.println(jsonResponse);
        System.out.println("Поиск города " + selectedCity + "...");

        if (objectMapper.readTree(jsonResponse).size() == 0) {
            throw new IOException("Server returns 0 cities");
        }

//        if (objectMapper.readTree(jsonResponse).size() > 0) {
//            for (JsonNode res : objectMapper.readTree(jsonResponse).at("/results")) {
//                for (JsonNode loc : res.at("/locations")) {
//                    System.out.println("/adminArea5: " + loc.at("/adminArea5").asText());
//                    System.out.println("/adminArea3: " + loc.at("/adminArea3").asText());
//                    System.out.println("selectedCity: " + selectedCity);
//                    System.out.println();
//                    if ((Objects.equals(loc.at("/adminArea5").asText(), selectedCity)) & (Objects.equals(loc.at("/adminArea3").asText(), selectedCity))) {
//                        String cityName = objectMapper.readTree(jsonResponse).at("/results/0/providedLocation/location").asText();
//                        String lat = objectMapper.readTree(jsonResponse).at("/results/0/locations/0/latLng/lat").asText();
//                        String lon = objectMapper.readTree(jsonResponse).at("/results/0/locations/0/latLng/lng").asText();
//                        System.out.println("Найден город " + cityName + " на широте " + lat + " и долготе " + lon);
//                    }
//                }
//            }
//        } else throw new IOException("Server returns 0 cities");

        return new String[]{objectMapper.readTree(jsonResponse).at("/results/0/locations/0/latLng/lat").asText(), objectMapper.readTree(jsonResponse).at("/results/0/locations/0/latLng/lng").asText()};
    }

    private static void loadProperties() throws IOException {
        try(FileInputStream configFile = new FileInputStream("src/main/resources/yandex.properties")){
            prop.load(configFile);
        }
    }
}
