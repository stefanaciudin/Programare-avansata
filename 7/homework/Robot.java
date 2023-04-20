package homework;

/**
 * Class Robot - defines the robots that explore the map
 * Has an attribute for the robot's name, one to check if the robot
 * is running or not and one to check if the robot has been paused
 * by the user or not
 */
public class Robot implements Runnable {
    private String name;
    private volatile boolean running;// by default, the robot is running
    private volatile boolean paused;
    private Exploration explore;
    private int tokensPlaced; //used to count how many tokens each robot has placed

    public Robot(String name, Exploration explore) {
        this.name = name;
        this.explore = explore;
        this.running = true;
        this.paused = false;
        this.tokensPlaced = 0;
    }

    public synchronized void setRunning(boolean running) {
        this.running = running;
    }

    public void setExploration(Exploration explore) {
        this.explore = explore;
    }

    public synchronized void pause() { //pause a robot
        paused = true;
        System.out.println("Robot " + this.getName() + " paused");
    }

    public synchronized void unpause() { //unpause a robot and notify all threads
        paused = false;
        notifyAll();
    }

    public synchronized void stop() {
        running = false;
    } //stop a robot from execution

    public synchronized void incrementTokensPlaced() {
        tokensPlaced++;
    } //after placing a token, increment the total

    public int getTokensPlaced() {
        return tokensPlaced;
    }


    public void run() { //the running function for the robot
        setRunning(true);
        System.out.println("Robot " + this.getName() + " started.");
        while (running) { //while not stopped
            synchronized (this) {
                while (paused) { //if paused - don't do anything
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            int[] cell = explore.getMap().getRandomUnvisitedCell();//get a new cell and visit it
            if (cell != null) {
                int row = cell[0];
                int col = cell[1];
                explore.getMap().visit(row, col, this);
            } else {
                explore.setAllCellsVisited();
                stop();//stop all robots when all cells are visited
            }
        }
        System.out.printf("%s terminated %n", name);
    }

    public String getName() {
        return this.name;

    }
}