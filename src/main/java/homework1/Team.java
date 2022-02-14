package homework1;
/**
 * Java Core. Homework 1
 *
 * @author Vitalii Luzhnov
 * @version 14.02.2022
 */
class Team {

    private static String nameTeam;
    private static int numberOfParticipants;
    private static int yearOfCreation;
    private static Participant[] participants;
    private boolean results = true;

    Team(String nameTeam, int numberOfParticipants, int yearOfCreation, Participant[] participants) {
        this.nameTeam = nameTeam;
        this.numberOfParticipants = numberOfParticipants;
        this.yearOfCreation = yearOfCreation;
        this.participants = participants;
    }

    Team() {}

    public static String getNameTeam() {
        return nameTeam;
    }

    public static int getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public static int getYearOfCreation() {
        return yearOfCreation;
    }

    public Participant[] getParticipant() { return participants; }

    public void setNameTeam(String nameTeam) {
        if (nameTeam != null) { this.nameTeam = nameTeam; }
    }

    public void setNumberOfParticipants(int numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    public void setParticipants(Participant[] participants) {
        this.participants = participants;
    }

    public void setYearOfCreation(int yearOfCreation) {
        this.yearOfCreation = yearOfCreation;
    }

    public void setResults(boolean results) {
        this.results = results;
    }

    public void showResults() {
        if (this.results == true) {
            System.out.println("The whole \"" + this.nameTeam + "\" team ran to the finish line.");
        } else {
            System.out.println("Not all the \"" + this.nameTeam + "\" team ran to the finish line.");
        }
    }
}
