package bonus;

/**
 * For a given n - number of nodes and degree, calculates the adjacency matrix
 * of a regular graph with n nodes and the given degree
 */
public class BonusEx2 {
    public static void printMatrix(int[][] matrix) { // prints a given square matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }

    }

    public static int[][] regularMatrix(int n, int degree) {
        int[][] matrix = new int[n][n];
        int numEdges;
        numEdges = degree / 2;
        if (degree > (n - 1)) { // input validation
            System.out.println("Input invalid, gradul nodurilor prea mare");
            System.exit(-1);
        } else if ((n * degree) % 2 != 0) {
            System.out.println("Input invalid, suma gradelor impara");
            System.exit(-1);
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < numEdges; j++) { // on each line, we have numEdges values of 1
                    int neighbor = (i + j + 1) % n; // for degree-even number, completes the graph in a circular manner
                    matrix[i][neighbor] = 1;
                    matrix[neighbor][i] = 1;
                    if (degree % 2 != 0) // for degree-odd number, adds for the current node the opposite node as neighbour
                        matrix[i][(i + n / 2) % n] = 1;
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] result;
        if (args.length == 2 && Integer.parseInt(args[0]) >= 1 && Integer.parseInt(args[1]) >= 1) {
            result = regularMatrix(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            printMatrix(result);
        } else
            System.out.println("Input invalid");

    }
}
