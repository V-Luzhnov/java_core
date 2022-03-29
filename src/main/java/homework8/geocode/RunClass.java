package homework8.geocode;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;
import java.util.Objects;

/**
 * Java Core. Homework 7
 *
 * @author Vitalii Luzhnov
 * @version 10.03.2022
 */
public class RunClass {


    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient();

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

        Request requestHTTP = new Request.Builder()
                .url(url)
                .build();

        String jsonResponse = Objects.requireNonNull(client.newCall(requestHTTP).execute().body()).string();
        System.out.println(jsonResponse);
    }
}
