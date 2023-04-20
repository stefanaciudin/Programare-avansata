package homework;

/**
 * Class TimeKeeper - used to keep track of how long the exploration takes
 * and stop its execution if the exploration takes
 * longer than a given amount of time.
 */
public class TimeKeeper implements Runnable {
    private final long timeLimit;
    private final Exploration explore;
    private final long startTime;
    private volatile boolean running;
    private volatile boolean timeLimitExceeded;
    private volatile long elapsedTime;

    public TimeKeeper(long timeLimit, Exploration explore) {
        this.timeLimit = timeLimit;
        this.explore = explore;
        this.startTime = System.currentTimeMillis();
        this.running = true;
        timeLimitExceeded = false;
    }

    @Override
    public void run() {
        while (running) {
            long currentTime = System.currentTimeMillis();
            elapsedTime = currentTime - startTime; //get elapsed time
            if (elapsedTime >= timeLimit) {//check if it's larger than the limit
                System.out.println("Time limit reached. Stopping exploration.");
                timeLimitExceeded = true;
                explore.stopAllRobots();
                running = false;
                System.exit(0); //exit execution with a status of 0
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public long getElapsedTime() {
        return elapsedTime;
    }

    public boolean isTimeLimitExceeded() {
        return timeLimitExceeded;
    }
}
