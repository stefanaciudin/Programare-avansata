package homework;

import java.util.ArrayList;
import java.util.List;
/**
 * Class Cell - used to represent a cell in the matrix
 * Has a boolean value visited to check if the cell has been visited or not
 * and a List of tokens that are placed in the given cell
 */
public class Cell {
    private boolean visited;
    private final List<Token> tokens;

    public Cell() {
        visited = false;
        tokens = new ArrayList<>();
    }

    public boolean isVisited() { //check if visited
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public void addTokens(List<Token> tokens) { //add tokens to the given matrix cell
        this.tokens.addAll(tokens);
    }

    @Override
    public String toString() {
        return "Cell{" +
                "visited=" + visited +
                ", tokens=" + tokens +
                '}';
    }
}
