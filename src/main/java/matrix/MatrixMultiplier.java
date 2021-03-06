package matrix;

import threads.ThreadMultiplier;

/**
 * This class provides multiplying method which can multiply two matrices
 */
public class MatrixMultiplier {

    private final int THREAD_COUNT = 3;

    /**
     * This method returns result of multiplying of two matrices
     * @param matrix1 - the first matrix
     * @param matrix2 - the second matrix
     * @return - result matrix
     * @throws InterruptedException - is thrown in case an error appeared while joining threads
     */
    public double[][] multiply(double[][] matrix1, double[][] matrix2) throws InterruptedException {
        int str1 = matrix1.length;
        int stolb2 = matrix2[0].length;
        double[][] resultMatrix = new double[str1][stolb2];

        // calculate the count of cells per thread based on the result matrix size
        int cellsForThreadCount = (str1 * stolb2) / THREAD_COUNT;
        ThreadMultiplier[] threadPull = new ThreadMultiplier[THREAD_COUNT];
        int firstIndex = 0;
        int lastIndex;

        // start every thread from the pull in the cycle
        for (int i = 0; i < THREAD_COUNT; i++) {
            lastIndex = firstIndex + cellsForThreadCount;

            // in case while dividing (str1 * stolb2) / THREAD_COUNT we didn't get integer
            // and we have cells to calculate left, we move last index to the last cell of the result matrix
            if (i == THREAD_COUNT - 1 && lastIndex < str1 * stolb2) {
                lastIndex = str1 * stolb2;
            }

            // create i-th thread
            threadPull[i] = new ThreadMultiplier(matrix1, matrix2, resultMatrix, firstIndex, lastIndex);
            threadPull[i].start();
            firstIndex = lastIndex;
        }

        // we finish the method only when all the threads finish their working
        for(final ThreadMultiplier thread: threadPull){
            thread.join();
        }

        return resultMatrix;
    }
}
