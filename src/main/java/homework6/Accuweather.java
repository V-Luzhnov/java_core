package homework6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.*;
import java.util.Objects;
import java.util.Properties;

/**
 * Java Core. Homework 6
 *
 * @author Vitalii Luzhnov
 * @version 04.03.2022
 */
public class Accuweather {
    static Properties prop = new Properties();

    public static void main(String[] args) throws IOException {
        loadProperties();
        OkHttpClient client = new OkHttpClient();

        // Сегментированное построение URL
        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host(prop.getProperty("BASE_HOST"))
                .addPathSegment(prop.getProperty("FORECAST"))
                .addPathSegment(prop.getProperty("API_VERSION"))
                .addPathSegment(prop.getProperty("FORECAST_TYPE"))
                .addPathSegment(prop.getProperty("FORECAST_PERIOD"))
                .addPathSegment(prop.getProperty("SAINT_PETERSBURG_KEY"))
                .addQueryParameter("apikey", prop.getProperty("API_KEY"))
                .addQueryParameter("language", "ru-ru")
                .addQueryParameter("metric", "true")
                .build();

        System.out.println(url);

        // При необходимости указать заголовки
        Request requestHTTP = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(url)
                .build();

        String jsonResponse = Objects.requireNonNull(client.newCall(requestHTTP).execute().body()).string();
        System.out.println(jsonResponse);
    }

    private static void loadProperties() throws IOException {
        try(FileInputStream configFile = new FileInputStream("src/main/resources/accuweather.properties")){
            prop.load(configFile);
        }
    }
}
