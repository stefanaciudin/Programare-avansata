package homework;

import java.util.*;

/**
 * Class Exploration - simulates the exploration of the map
 */
public class Exploration {


    private static final SharedMemory mem = new SharedMemory(150);
    private static final ExplorationMap map = new ExplorationMap(150, mem);
    private static final List<Robot> robots = new ArrayList<>();
    private volatile boolean allCellsVisited = false; // for starters, none of the cells are visited

    public void addRobot(Robot robot) {
        robots.add(robot);
    }

    public void startAllRobots() { //method to start all robots
        for (Robot robot : robots) {
            robot.setRunning(true);
            new Thread(robot).start();
        }
    }

    void stopAllRobots() { //method to stop all robots
        for (Robot robot : robots)
            robot.stop();
    }

    public void pauseAllRobots() { //method to pause all robots
        for (Robot robot : robots) {
            robot.pause();
        }
    }

    public void startRobot(int robotIndex) { //method to start a given robot
        if (robotIndex >= 0 && robotIndex < robots.size()) {
            Robot robot = robots.get(robotIndex);
            robot.setRunning(true);
            new Thread(robot).start();
        } else {
            System.out.println("Robot doesn't exist");
        }
    }

    public void pauseRobotForever(int robotIndex) { //pause a robot forever, and make it require a start command
        if (robotIndex >= 0 && robotIndex < robots.size()) {
            Robot robot = robots.get(robotIndex);
            robot.pause();
        }
    }

    public void pauseRobot(int robotIndex, int seconds) { //pause a robot for a given amount of seconds
        if (robotIndex >= 0 && robotIndex < robots.size()) {
            Robot robot = robots.get(robotIndex);
            robot.pause();
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    robot.unpause();
                }
            }, seconds * 1000L);
        }
    }

    public synchronized void setAllCellsVisited() {
        allCellsVisited = true;
        for (Robot robot : robots) {
            robot.setRunning(false);
        }
    }

    public synchronized boolean areAllCellsVisited() {
        return allCellsVisited;
    }

    public ExplorationMap getMap() {
        return map;
    }

    public static void main(String[] args) {
        Exploration explore = new Exploration();
        //System.out.println("Initial shared memory: " + mem);

        explore.addRobot(new Robot("Wall-E", explore));
        explore.addRobot(new Robot("R2D2", explore));
        explore.addRobot(new Robot("Optimus Prime", explore));
        //explore.startAllRobots();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter command (start, pause, pause <robotIndex> <numberOfSeconds>, pause <robotIndex>, start <robotIndex> , stop):");

        //prepare the timekeeper thread, make it a daemon thread
        //and start it
        TimeKeeper tk = new TimeKeeper(300_000, explore);
        Thread tkThread = new Thread(tk);
        tkThread.setDaemon(true);
        tkThread.start();

        while (!explore.areAllCellsVisited()) { //get user input and act accordingly
            String command = scanner.nextLine();
            if (command.equals("start")) {
                explore.startAllRobots();
            } else if (command.startsWith("start ")) {
                for (Robot r : robots)
                    r.unpause();
                String[] tokens = command.split("\\s+");
                if (tokens.length == 2) {
                    int robotIndex = Integer.parseInt(tokens[1]);
                    explore.startRobot(robotIndex);
                }
            } else if (command.equals("pause")) {
                explore.pauseAllRobots();
            } else if (command.startsWith("pause")) {
                String[] tokens = command.split("\\s+");
                if (tokens.length == 2) {
                    int robotIndex = Integer.parseInt(tokens[1]);
                    explore.pauseRobotForever(robotIndex);
                }
                if (tokens.length == 3) {
                    int robotIndex = Integer.parseInt(tokens[1]);
                    int seconds = Integer.parseInt(tokens[2]);
                    explore.pauseRobot(robotIndex, seconds);
                }
            } else if (command.equals("stop") || tk.isTimeLimitExceeded()) {
                explore.stopAllRobots();
                break;
            } else
                System.out.println("Incorrect command.");
        }

        scanner.close();
        System.out.println("Exploration finished, elapsed time: " + tk.getElapsedTime()); //print info
        for (Robot r : robots)
            System.out.println("Robot " + r.getName() + " has placed " + r.getTokensPlaced() + " tokens in the matrix.");

        //System.out.println(map);
    }

}

