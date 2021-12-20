package matrix;

public class MatrixMultiplication {
    public static int[][] matrixMultiply(int[][] matrix1, int[][] matrix2) {
        //Creates a resault matrix according to matrix multiplication rules
        int result[][] = new int[matrix1.length][matrix2[0].length];

        MatrixRowMultiplier[] mrm = new MatrixRowMultiplier[matrix1.length];
        //Creates matrix row multiplier object and call calculate function in main thread.
        for (int i = 0; i < matrix1.length ; i++) {
            mrm[i] = new MatrixRowMultiplier(matrix1[i],matrix2);
            mrm[i].multiplyByRow();
            result[i] = mrm[i].getResult();
        }


        return result;
    }
    public static int[][] parallelMatrixMultiply(int[][] matrix1, int[][] matrix2){
        //Creates a result matrix according to matrix multiplication rules
        int result[][] = new int[matrix1.length][matrix2[0].length];
        MatrixRowMultiplier[] mrm = new MatrixRowMultiplier[matrix1.length];

        //Creates matrix row multiplier object  and call calculate function in individual threads.
        for (int i = 0; i < matrix1.length ; i++) {
            mrm[i] = new MatrixRowMultiplier(matrix1[i],matrix2);
            mrm[i].start();
        }
        //Waits for all threads to finish.
        for(Thread thread : mrm){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Add results together
        for (int i = 0; i < matrix1.length ; i++) {
            result[i] = mrm[i].getResult();
        }
        //returns result
        return result;
    }

}
