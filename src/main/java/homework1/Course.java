package homework1;
/**
 * Java Core. Homework 1
 *
 * @author Vitalii Luzhnov
 * @version 14.02.2022
 */
class Course {

    final String Q_PARTICIPANT = "Participant ";
    final String Q_DID_NOT_RAN = " did not ran the obstacle course.";
    final String Q_RAN = " ran the obstacle course.";

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
                System.out.println(Q_PARTICIPANT + participant.getName() + Q_DID_NOT_RAN);
                team.setResults(false);
            } else{
                System.out.println(Q_PARTICIPANT + participant.getName() + Q_RAN);
            }
        }
    }

    boolean successfulResult(int participantCanRun, int participantWeight) {
        return participantCanRun < this.distance || participantWeight > this.bridgeLiftingCapacity;
    }
}
