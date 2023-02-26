package bonus1;

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
        if ((n * degree) % 2 != 0) {
            System.out.println("Input invalid, suma gradelor impara");
            System.exit(-1);
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= numEdges; j++) {
                    int neighbor = (i + j + 1) % n;
                    matrix[i][neighbor] = 1;
                    matrix[neighbor][i] = 1;
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
