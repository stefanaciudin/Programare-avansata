package homework1;

/**
 * Creates a nxn Latin Square as a matrix
 * For each line and column, the symbols in the matrix are concatenated
 * and displayed on the screen as String objects
 * For n>30_000, only the running time is displayed
 */
public class Homework1 {
    static void matrixGenerator(int n) {
        long startTime = System.nanoTime(); // starts counting the time
        // matrix creation
        int[][] latinSquare = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                latinSquare[i][j] = (n - i + j) % n + 1; // right shift values for each row by 1
        }
        int j;
        for (int i = 0; i < n; i++) {
            String row = "";
            String column = "";
            for (j = 0; j < n; j++) {
                row = row.concat(Integer.toString(latinSquare[i][j])); // concatenation of the symbols from a row
                column = column.concat(Integer.toString(latinSquare[j][i])); // concatenation of the symbols from a column
            }
            if (n <= 30000) { // prints the strings only if n<=30_000
                System.out.print("Row number " + (i + 1) + ":" + row + " ");
                System.out.print("Column number " + (i + 1) + ":" + column + " ");
                System.out.println();
            }
        }
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime; // calculates the running time
        if (n > 30000)
            System.out.println("Execution time in nanoseconds: " + timeElapsed);

    }


    public static void main(String[] args) { // args validation
        if (args.length == 1 && (Integer.parseInt(args[0])) > 0)
            matrixGenerator(Integer.parseInt(args[0]));
        else
            System.out.println("Input invalid");

    }

}
