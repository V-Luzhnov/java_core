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
public class Yandex {
    static Properties prop = new Properties();

    public static void main(String[] args) throws IOException {

        loadProperties();
        OkHttpClient client = new OkHttpClient();

        // Сегментированное построение URL
        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host(prop.getProperty("BASE_HOST"))
                .addPathSegment(prop.getProperty("API_VERSION"))
                .addPathSegment(prop.getProperty("FORECAST"))
                .addQueryParameter("lat", prop.getProperty("LAT"))
                .addQueryParameter("lon", prop.getProperty("LON"))
                .addQueryParameter("lang", prop.getProperty("LANG"))
                .addQueryParameter("limit", prop.getProperty("LIMIT"))
                .build();

        System.out.println(url);

        // Указание заголовка
        Request requestHTTP = new Request.Builder()
                .url(url)
                .addHeader("X-Yandex-API-Key", prop.getProperty("API_KEY"))
                .build();

        String jsonResponse = Objects.requireNonNull(client.newCall(requestHTTP).execute().body()).string();
        System.out.println(jsonResponse);
    }

    private static void loadProperties() throws IOException {
        try(FileInputStream configFile = new FileInputStream("src/main/resources/yandex.properties")){
            prop.load(configFile);
        }
    }
}
