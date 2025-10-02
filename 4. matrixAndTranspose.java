// @author - el
// DISCLAIMER !
// Kode ini hanyalah implementasi konsep dasar 

public class main {
    public static void matrixAndTranspose(String[] args){
        Scanner sc = new Scanner(System.in);

// declare and initialize a 3x3 matrix
        int matrix[][] =
                { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        // display matrix using for loops
        // outer loop for row
        for(int row =0; row <matrix.length; row++) {
            // inner loop for column
            for(int column=0; column <matrix[row].length; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println(); // new line
        }

        System.out.println();
        // display matrix using for loops
        // outer loop for row
        for(int row =0; row <matrix.length; row++) {
            // inner loop for column
            for(int column=0; column <matrix[row].length; column++) {
                System.out.print(matrix[column][row] + " ");
            }
            System.out.println(); // new line
        }
  }
}
