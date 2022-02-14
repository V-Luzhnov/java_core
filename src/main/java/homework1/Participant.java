package homework1;

import homework1.enums.Sex;

class Participant extends Team {

    private String name;
    private Sex sex;
    private int age;
    private int weight;
    private int canRun;
    private static int count = 0;

    Participant(String name, Sex sex, int age, int weight, int canRun) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.weight = weight;
        this.canRun = canRun;
        count++;
    }
    public static int getCountOfParticipant() {
        return count;
    }

    public String getName() {
        return name;
    }

    public Sex getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public int getCanRun() {
        return canRun;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setCanRun(int canRun) {
        this.canRun = canRun;
    }

    @Override
    public String toString() {
        return name + " (sex: " + sex + ", age: " + age + ", weight: " + weight + ", can run: " + canRun + ")";
    }
}
