package homework4.exercise2;
/**
 * Java Core. Homework 4.2
 *
 * @author Vitalii Luzhnov
 * @version 27.02.2022
 */
public class RunClass {

    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        phonebook.add("123456789","Sergeev");
        phonebook.add("123456780","Ivanov");
        phonebook.add("234567891","Petrov");
        phonebook.add("103456789","Ivanov");
        phonebook.add("345678912","Fedorov");
        phonebook.add("123056789","Ivanov");

        System.out.println(phonebook.getPhoneBySurname("Ivanov"));
    }
}
