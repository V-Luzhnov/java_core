package homework1;

import homework1.enums.Sex;

public class Steeplechase {
    public static void main(String[] args) {

        Course course = new Course();
        course.setDistance(5000);
        course.setBridgeLiftingCapacity(100);
//        course.setDistance(7000);
//        course.setBridgeLiftingCapacity(60);

        System.out.println();
        System.out.println("Distance: " + course.getDistance() + " m | Bridge lifting capacity: " + course.getBridgeLiftingCapacity());

        Team team = new Team();
        team.setNameTeam("Rocket");
        team.setYearOfCreation(2020);

        Participant[] participants = {
                new Participant("Ivan", Sex.male, 27, 80, 10000),
                new Participant("Kate", Sex.female, 20, 50, 5000),
                new Participant("Piter", Sex.male, 40, 90, 10000),
                new Participant("Juli", Sex.female, 34, 55, 10000)
        };

        team.setParticipants(participants);
        team.setNumberOfParticipants(Participant.getCountOfParticipant());

        System.out.println();

        System.out.println("Team: " + team.getNameTeam() +
                " | Year of formation: " + team.getYearOfCreation() +
                " | Number of participants: " + team.getNumberOfParticipants());

        int numberParticipant= 1;
        for (Participant participant : team.getParticipant()) {
            System.out.println("Participant " + numberParticipant + ": " + participant.toString());
            numberParticipant++;
        }

        System.out.println();

        course.doIt(team);

        System.out.println();

        team.showResults();
    }
}
