package matrix;

public class TestMatrixMultiply {

    public static void main(String[] args) {
        //Creates two 1000x1000 matrix
        int[][] m1 = MatrixGenerator.generateMatrix(1000,1000);
        int[][] m2 = MatrixGenerator.generateMatrix(1000,1000);



        System.out.println("Single thread time: ");
        long t1 = System.currentTimeMillis();
        //runs in single thread
        MatrixMultiplication.matrixMultiply(m1,m2);
        long t2 = System.currentTimeMillis();
        System.out.println("Time results : " + (t2-t1));

        System.out.println("Multi thread time: ");
        t1 = System.currentTimeMillis();
        //runs in multi thread
        MatrixMultiplication.parallelMatrixMultiply(m1,m2);
        t2 = System.currentTimeMillis();
        System.out.println("Time results : " + (t2-t1));

    }

}
