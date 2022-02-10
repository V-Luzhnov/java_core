package homework1;

import homework1.enums.Sex;

public class Steeplechase {
    public static void main(String[] args) {

        ITeam[] team = {
                new Participant("Ваня", Sex.male, 27),
                new Participant("Юля", Sex.female, 20),
                new Participant("Петя", Sex.male, 40),
                new Participant("Света", Sex.female, 34)
        };

        for (ITeam participant : team) {
            System.out.println(participant.toString());
            System.out.println(participant.toString());
        }
    }
}
