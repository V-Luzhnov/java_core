package homework7.geocode;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;
import java.util.Objects;

/**
 * Java Core. Homework 7
 *
 * @author Vitalii Luzhnov
 * @version 09.03.2022
 */
public class RunClass {


    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient();

        // Сегментированное построение URL
        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host("open.mapquestapi.com")
                .addPathSegment("geocoding")
                .addPathSegment("v1")
                .addPathSegment("address")
                .addQueryParameter("key", "HdFtWAHAqnCKgYczZGqfKIEjiAl65MhC")
                .addQueryParameter("location", "Moscow")
                .build();

        System.out.println(url);

        // Указание заголовка
        Request requestHTTP = new Request.Builder()
                .url(url)
//                .addHeader("")
//                .addHeader("X-Yandex-API-Key", prop.getProperty("API_KEY"))
                .build();

        String jsonResponse = Objects.requireNonNull(client.newCall(requestHTTP).execute().body()).string();
        System.out.println(jsonResponse);

//        ObjectMapper mapper = new ObjectMapper();
//        StringReader reader = new StringReader(jsonResponse);
//
//        WeatherResponse weatherResponse = mapper.readValue(reader, WeatherResponse.class);
//
//        String city = mapper
//                .readTree(jsonResponse)
//                .at("/geo_object/locality/name")
//                .asText();
//
//        for (Forecast forecast : weatherResponse.getForecasts()) {
//            System.out.println(
//                    "В городе " + city +
//                    " на дату " + forecast.getDate() +
//                    " ожидается " + forecast.getParts().getDay_short().getCondition() +
//                    ", температура " + forecast.getParts().getDay_short().getTemp()
//                    );
//        }
    }
}
