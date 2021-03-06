package homework1;

import homework1.enums.Sex;
/**
 * Java Core. Homework 1
 *
 * @author Vitalii Luzhnov
 * @version 14.02.2022
 */
public class Steeplechase {
    public static void main(String[] args) {

        final String Q_M = " m";
        final String Q_KG = " kg";

        Course course = new Course();
        course.setDistance(5000); //длина дистанции
        course.setBridgeLiftingCapacity(100); //грузоподъемность моста на дистанции
//        course.setDistance(7000);
//        course.setBridgeLiftingCapacity(60);

        System.out.println();
        System.out.println("Distance: " + course.getDistance() + Q_M + " | Bridge lifting capacity: " + course.getBridgeLiftingCapacity() + Q_KG);

        Team team = new Team();
        team.setNameTeam("Rocket");
        team.setYearOfCreation(2020);

        //Участники = Имя | Пол | Возраст | Вес | Может пробежать |
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
            System.out.println("Participant " + numberParticipant + ": " + participant);
            numberParticipant++;
        }

        System.out.println();

        course.doIt(team);

        System.out.println();

        team.showResults();
    }
}
