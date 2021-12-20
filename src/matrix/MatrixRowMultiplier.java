package matrix;
public class MatrixRowMultiplier extends Thread{
    private int[] row;
    private int[][] matrix;
    private int[] result;
    public MatrixRowMultiplier(int[] row, int[][] matrix){
        this.row = row;
        this.matrix = matrix;
        // Creates result vector according to the inputs
        this.result = new int[matrix[0].length];
    }
    public void multiplyByRow(){
        //Matrix multiplication.
        for(int i = 0; i< matrix[0].length; i++){
            for(int k = 0; k<row.length ; k++){
                result[i] += row[k] * matrix[k][i];
            }
        }
    }
    @Override
    public void run(){
        //Calls calculation method
        multiplyByRow();
    }


    public int[] getResult(){
        //returns result of matrix
        return result;
    }
}
