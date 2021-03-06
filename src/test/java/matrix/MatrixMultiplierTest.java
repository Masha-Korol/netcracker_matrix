package matrix;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MatrixMultiplierTest {

    @Test
    void multiply1() throws InterruptedException {
        MatrixMultiplier matrixMultiplier = new MatrixMultiplier();

        double[][] matrix1 = {{4, 1, 2}, {10, 6, 3}, {5, 5, 5.8}, {1, 5, 6.1}};
        double[][] matrix2 = {{4, 10, 5.2, 9.3}, {15, 3.12, 16, 31}, {4.3, 17, 6.1, 5}};
        double[][] correctResult = {{39.6, 77.12, 49.0, 78.2}, {142.9, 169.72, 166.3, 294.0}, {119.94, 164.2, 141.38, 230.5}, {105.22999999999999, 129.29999999999998, 122.41, 194.8}};
        double[][] resultMatrix = matrixMultiplier.multiply(matrix1, matrix2);

        assertArrayEquals(resultMatrix, correctResult);
    }

    @Test
    void multiply2() throws InterruptedException {
        MatrixMultiplier matrixMultiplier = new MatrixMultiplier();

        double[][] matrix1 = {{2, 2}, {1, 0}, {11, 23}, {56.7, 12.4}, {32, 11}, {10, 3}};
        double[][] matrix2 = {{12.34, 10, 16, 17}, {4, 5, 22, 10.11}};
        double[][] correctResult = {{32.68, 30.0, 76.0, 54.22}, {12.34, 10.0, 16.0, 17.0}, {227.74, 225.0, 682.0, 419.53},
                {749.278, 629.0, 1180.0, 1089.2640000000001}, {438.88, 375.0, 754.0, 655.21}, {135.4, 115.0, 226.0, 200.32999999999998}};
        double[][] resultMatrix = matrixMultiplier.multiply(matrix1, matrix2);

        assertArrayEquals(resultMatrix, correctResult);
    }
}
