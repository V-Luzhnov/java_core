package homework1;

import homework1.enums.Sex;

public class Steeplechase {
    public static void main(String[] args) {

        Course Course = new Course();
        Course.setDistance(5000);
        Course.setMaxObstacleHeight(200);
        Course.setNumberOfObstacles(10);

        System.out.println();
        System.out.println("Distance: " + Course.getDistance() + " m | Number of obstacles: " + Course.getNumberOfObstacles());

        Team Team = new Team();
        Team.setNameTeam("Rocket");
        Team.setYearOfCreation(2020);

        Participant[] participants = {
                new Participant("Ivan", Sex.male, 27, 80, 10000),
                new Participant("Kate", Sex.female, 20, 50, 5000),
                new Participant("Piter", Sex.male, 40, 90, 10000),
                new Participant("Juli", Sex.female, 34, 55, 10000)
        };

        Team.setParticipants(participants);
        Team.setNumberOfParticipants(Participant.getCountOfParticipant());

//        System.out.println();
        System.out.println("Team: " + Team.getNameTeam() +
                " | Year of formation: " + Team.getYearOfCreation() +
                " | Number of participants: " + Team.getNumberOfParticipants());

//        System.out.println();

        int numberParticipant= 1;
        for (Participant participant : Team.getParticipant()) {
            System.out.println("Participant " + numberParticipant + ": " + participant.toString());
//            System.out.println("weight: " + participant.getName());
            numberParticipant++;
        }

//        Course Course = new Course();
//        Course.setDistance(1000);

//        System.out.println();
//        System.out.println("Course: " + Course.getDistance());

//        System.out.println(Team.run(150, 5));

    }
}
