package homework1;

class Team {
//    class Team implements ITeam {

    private static String nameTeam;
    private static int numberOfParticipants;
    private static int yearOfCreation;
    private static Participant[] participants;

    Team(String nameTeam, int numberOfParticipants, int yearOfCreation, Participant[] participants) {
        this.nameTeam = nameTeam;
        this.numberOfParticipants = numberOfParticipants;
        this.yearOfCreation = yearOfCreation;
        this.participants = participants;
    }

//    public Team(String nameTeam) {
//        this.nameTeam = nameTeam;
//    }
//
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

    public Participant[] getParticipant() {
        return participants;
    }

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

//    @Override
//    public String run(int distance, int q) {
//        if (distance > numberOfParticipants) {
//            return numberOfParticipants + " couldn't run " + distance;
//        } else {
//            return numberOfParticipants + " successfully ran " + distance;
//        }
//    }

//    @Override
//    public String run(int distance) {
//        return name + (distance > limitRun ? " не " : " ") + "пробежал " + distance + " м";
//    }

}
