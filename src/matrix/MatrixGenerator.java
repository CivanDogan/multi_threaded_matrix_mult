package matrix;

import java.util.Random;

public class MatrixGenerator {
    private static Random random = new Random();


    public static int[][] generateMatrix(int rows,int columns){
        //Creates empty matrix
        int matrix[][]  = new int[rows][columns];
        //Fills with random values between 0 to 9
        for(int i = 0; i < rows ; i++){
            for (int k = 0; k<columns;k++ ){
                matrix[i][k] = random.nextInt(0,10);
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix){
        // Prints matrix with empty spaces
        // Prints dashes in beginning and end
        System.out.println(matrix.toString()+ "  : ");
        System.out.println("-------------");
        for(int i = 0; i < matrix.length ; i++){
            for (int k = 0; k<matrix[0].length;k++ ){
                System.out.print(matrix[i][k]+" ");
            }
            System.out.println();
        }
        System.out.println("-------------");

    }
}
