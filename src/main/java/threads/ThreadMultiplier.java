package threads;

/**
 * This Thread is used to calculate part of the matrix which is a result of multiplying of two matrices
 */
public class ThreadMultiplier extends Thread {

    private double[][] matrix1;
    private double[][] matrix2;
    private double[][] resultMatrix;
    private int firstIndex;
    private int lastIndex;

    public ThreadMultiplier(double[][] matrix1, double[][] matrix2, double[][] resultMatrix, int firstIndex, int lastIndex) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.resultMatrix = resultMatrix;
        this.firstIndex = firstIndex;
        this.lastIndex = lastIndex;
    }

    /**
     * This run method calls calculateCell() method in the cycle for every cell that is under current thread control
     */
    @Override
    public void run() {
        for (int i = firstIndex; i < lastIndex; i++) {
            int strIndex = i / resultMatrix[0].length;
            int stolbIndex = i % resultMatrix[0].length;
            calculateCell(strIndex, stolbIndex);
        }
    }

    /**
     * This method calculates a cell of result matrix
     * @param strIndex - number of the string where the cell is located
     * @param stolbIndex - number of the column where the cell is located
     */
    private void calculateCell(int strIndex, int stolbIndex) {
        for (int i = 0; i < matrix1[0].length; ++i) {
            resultMatrix[strIndex][stolbIndex] += matrix1[strIndex][i] * matrix2[i][stolbIndex];
        }
    }
}
