package homework1;

class Course {
    private int distance;
    private int maxObstacleHeight;
    private int numberOfObstacles;

    Course(int distance, int maxObstacleHeight, int numberOfObstacles) {

        this.distance = distance;
        this.maxObstacleHeight = maxObstacleHeight;
        this.numberOfObstacles = numberOfObstacles;
    }

    Course() {
    }

    public int getDistance() {
        return distance;
    }

    public int getMaxObstacleHeight() {
        return maxObstacleHeight;
    }

    public int getNumberOfObstacles() {
        return numberOfObstacles;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setMaxObstacleHeight(int maxObstacleHeight) {
        this.maxObstacleHeight = maxObstacleHeight;
    }

    public void setNumberOfObstacles(int numberOfObstacles) {
        this.numberOfObstacles = numberOfObstacles;
    }
}
