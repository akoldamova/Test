import java.util.Arrays;

public class Matrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int rotations = 2;
        
        for (int i = 0; i < rotations; i++) {
            for (int row = 0; row < matrix.length; row++) {
                for (int col = row; col < matrix.length; col++) {
                    if (row != col) {
                        int currentElement = matrix[row][col];
                        matrix[row][col] = matrix[col][row];
                        matrix[col][row] = currentElement;
                    }
                }
            }
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix.length / 2; col++) {
                    int currentElement = matrix[row][col];
                    matrix[row][col] = matrix[row][matrix.length - col - 1];
                    matrix[row][matrix.length - col - 1] = currentElement;

                }
            }
        }

        for (int[] arr : matrix) {
            System.out.println(Arrays.toString(arr).replace(",","_")
                    .replace("[","")
                    .replace("]",""));
        }
    }
}
