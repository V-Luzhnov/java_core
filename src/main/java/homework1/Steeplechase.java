package homework1;

import homework1.enums.Sex;

public class Steeplechase {
    public static void main(String[] args) {

        ITeam[] team = {
                new Participant("Ivan", Sex.male, 27),
                new Participant("Kate", Sex.female, 20),
                new Participant("Piter", Sex.male, 40),
                new Participant("Juli", Sex.female, 34)
        };

        for (ITeam participant : team) {
            System.out.println(participant.toString());
        }
    }
}
