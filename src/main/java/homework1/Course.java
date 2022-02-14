package homework1;
/**
 * Java Core. Homework 1
 *
 * @author Vitalii Luzhnov
 * @version 14.02.2022
 */
class Course {

    final String Q_PARTICIPANT = "Participant ";

    private int distance;
    private int bridgeLiftingCapacity;

    Course(int distance, int bridgeLiftingCapacity) {

        this.distance = distance;
        this.bridgeLiftingCapacity = bridgeLiftingCapacity;
    }

    Course() {
    }

    public int getDistance() {
        return distance;
    }

    public int getBridgeLiftingCapacity() {
        return bridgeLiftingCapacity;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setBridgeLiftingCapacity(int bridgeLiftingCapacity) {
        this.bridgeLiftingCapacity = bridgeLiftingCapacity;
    }

    public void doIt(Team team) {
        for (Participant participant : team.getParticipant()) {
            if (participant.getCanRun() < this.distance || participant.getWeight() > this.bridgeLiftingCapacity) {
                System.out.println(Q_PARTICIPANT + participant.getName() + " did not ran the obstacle course");
                team.setResults(false);
            } else{
                System.out.println(Q_PARTICIPANT + participant.getName() + " ran the obstacle course");
            }
        }
    }

    boolean successfulResult(int participantCanRun, int participantWeight) {
        return participantCanRun < this.distance || participantWeight > this.bridgeLiftingCapacity;
    }
}
