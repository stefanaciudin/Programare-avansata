package homework;

import java.util.ArrayList;
import java.util.List;

/**
 * Class ExplorationMap - defined by a matrix of Cells and a shared memory
 * that has all the tokens from which the robots can pick
 */
public class ExplorationMap {
    private final Cell[][] matrix;
    private final SharedMemory mem;

    public ExplorationMap(int n, SharedMemory mem) {
        matrix = new Cell[n][n];
        for (int i = 0; i < n; i++) { //generate new matrix of cells
            for (int j = 0; j < n; j++) {
                matrix[i][j] = new Cell();
            }
        }
        this.mem = mem;
    }

    public int[] getRandomUnvisitedCell() { //pick a random unvisited cell
        List<int[]> unvisitedCells = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!matrix[i][j].isVisited()) { // adding to the list all the unvisited cells
                    unvisitedCells.add(new int[]{i, j});
                }
            }
        }
        if (!unvisitedCells.isEmpty()) {
            int[] randomCell = unvisitedCells.get((int) (Math.random() * unvisitedCells.size()));
            return new int[]{randomCell[0], randomCell[1]};
        } else {
            return null; //exploration complete
        }
    }


    public void visit(int row, int col, Robot robot) {
        //only one robot can visit the same cell at a time
        //to ensure this - we use the synchronized keyword
        synchronized (matrix[row][col]) {
            if (!matrix[row][col].isVisited()) {
                List<Token> tokens = mem.extractTokens(matrix.length); //extract n tokens
                matrix[row][col].addTokens(tokens); //add the tokens in the cell
                matrix[row][col].setVisited(true); //mark the cell as visited
                robot.incrementTokensPlaced();
                //System.out.println(robot.getName() + " visited cell [" + row + ", " + col + "]");
            }
        }


    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append("[").append(i).append(",").append(j).append("]: ");
                sb.append(matrix[i][j].getTokens().toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
