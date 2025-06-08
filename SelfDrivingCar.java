class SelfDrivingCar {
    String lanePosition;
    boolean obstacleDetected;
    boolean trafficSignalRed;

    public SelfDrivingCar() {
        this.lanePosition = "center";
        this.obstacleDetected = false;
        this.trafficSignalRed = false;
    }

    public void senseEnvironment(boolean obstacle, boolean redSignal) {
        this.obstacleDetected = obstacle;
        this.trafficSignalRed = redSignal;
    }

    public void makeDecision() {
        if (trafficSignalRed) {
            stop();
        } else if (obstacleDetected) {
            avoidObstacle();
        } else {
            driveForward();
        }
    }

    public void stop() {
        System.out.println("Stopping at red signal...");
    }

    public void avoidObstacle() {
        System.out.println("Obstacle detected! Taking evasive action...");
        changeLane();
    }

    public void driveForward() {
        System.out.println("Driving forward safely in " + lanePosition + " lane.");
    }

    public void changeLane() {
        if (lanePosition.equals("center")) {
            lanePosition = "left";
        } else if (lanePosition.equals("left")) {
            lanePosition = "right";
        } else {
            lanePosition = "center";
        }
        System.out.println("Changed lane to: " + lanePosition);
    }

    public static void main(String[] args) {
        SelfDrivingCar car = new SelfDrivingCar();

        // Simulate environment sensing
        System.out.println("\n--- Scenario 1: Clear road ---");
        car.senseEnvironment(false, false);
        car.makeDecision();

        System.out.println("\n--- Scenario 2: Obstacle ahead ---");
        car.senseEnvironment(true, false);
        car.makeDecision();

        System.out.println("\n--- Scenario 3: Red light ---");
        car.senseEnvironment(false, true);
        car.makeDecision();
    }
}
