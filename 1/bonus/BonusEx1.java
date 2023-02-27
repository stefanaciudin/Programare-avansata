package bonus;

/**
 * Generates the adjacency matrix for a cycle graph C_n
 * Computes the powers A^2, A^3,..., A^n for the created matrix
 * Prints the matrix and the obtained powers
 */
public class BonusEx1 {

    public static void printMatrix(int[][] matrix) { // prints a given square matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }

    public static int[][] cycleMatrix(int n) { // creates the matrix for the graph C_n
        int[][] matrix = new int[n][n];
        matrix[0][1] = 1; // the node 0 has 1 and n-1 as neighbours
        matrix[0][n - 1] = 1;
        matrix[n - 1][0] = 1; // the node n-1 has 0 and n-2 as neighbours
        matrix[n - 1][n - 2] = 1;
        for (int i = 1; i <= n - 2; i++) {
            matrix[i][i - 1] = matrix[i][i + 1] = 1; // each node has i-1 and i+1 as neighbours
        }
        printMatrix(matrix);
        return matrix;
    }

    public static int[][] matrixPower(int[][] matrix1, int[][] matrix2) { // calculates the product M*M
        int n = matrix1.length; // n = matrix1.length = matrix.2length = matrix1[0].length = matrix2[0].length
        int[][] result = new int[n][n]; // stores the result of the multiplication
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        if (args.length == 1 && (Integer.parseInt(args[0])) >= 3) { // args validation
            int size = Integer.parseInt(args[0]);
            int[][] initial;
            int[][] result;
            initial = result = cycleMatrix(size);
            for (int i = 2; i <= size; i++) { // calculates each power from 2 to n
                result = matrixPower(initial, result);
                System.out.println("Puterea " + i + " este: ");
                printMatrix(result);
            }

        } else System.out.println("Input invalid");

    }

}

