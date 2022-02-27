package homework4.exercise2;

import java.util.HashMap;

/**
 * Java Core. Homework 4.2
 *
 * @author Vitalii Luzhnov
 * @version 27.02.2022
 */
public class Phonebook {

    private final HashMap<String,String> stringStringHashMap = new HashMap<>();

    public void add(String phone, String surname){
        stringStringHashMap.put(phone, surname);
    }

    public String getPhoneBySurname(String surname){
        if(stringStringHashMap.containsValue(surname)){
            StringBuilder result = new StringBuilder(surname + " phone numbers: ");
            for(String key: stringStringHashMap.keySet()){
                if(stringStringHashMap.get(key).equals(surname)) {
                    result.append(key).append("; ");
                }
            }
            return result.substring(0, result.length() - 2);
        } else return surname + " phone number not found";
    }
}
