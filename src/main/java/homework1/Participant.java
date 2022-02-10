package homework1;

import homework1.enums.Sex;

class Participant extends Team {

    private String name;
    private Sex sex;
    private int age;

    Participant(String name, Sex sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name: " + name;
    }
}
