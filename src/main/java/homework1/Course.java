package homework1;

class Course {
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
                System.out.println("Participant " + participant.getName() + " did not ran the obstacle course");
                team.setResults(false);
            } else{
                System.out.println("Participant " + participant.getName() + " ran the obstacle course");
            }
        }
    }

    boolean successfulResult(int participantCanRun, int participantWeight) {
        return participantCanRun < this.distance || participantWeight > this.bridgeLiftingCapacity;
    }
}
