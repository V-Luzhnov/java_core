package homework7;

import java.util.Properties;

/**
 * Java Core. Homework 7
 *
 * @author Vitalii Luzhnov
 * @version 10.03.2022
 */
public final class ApplicationGlobalState {

    private static ApplicationGlobalState INSTANCE;
    private String selectedCity = null;
    private final String apiKey = "042c1335-f285-4f4c-b25a-1b0f561cacce";
    private final String apiKeyForCity = "HdFtWAHAqnCKgYczZGqfKIEjiAl65MhC";

    private ApplicationGlobalState() {
    }

    // Непотокобезопасный код для упрощения
    public static ApplicationGlobalState getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ApplicationGlobalState();
        }

        return INSTANCE;
    }

    public String getSelectedCity() {
        return selectedCity;
    }

    public void setSelectedCity(String selectedCity) {
        this.selectedCity = selectedCity;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getApiKeyForCity() {
        return apiKeyForCity;
    }
}
