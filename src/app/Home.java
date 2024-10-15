package app;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

public class Home {
    public static void main(String[] args) {
        int[][] matrix2 = new int[4][4];
        Random random = new SecureRandom();
        System.out.println("Матриця 4x4:");

        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                matrix2[i][j] = random.nextInt(50) + 1;
            }
            System.out.println(Arrays.toString(matrix2[i]));
        }

        int evenRowsSum = 0;
        int oddRowsSum = 0;
        int evenColumnsProduct = 1;
        int oddColumnsProduct = 1;
        int columnSum = 0;
        int rowSum = 0;
        int diagonalSum1 = 0;
        int diagonalSum2 = 0;

        for (int i = 0; i < matrix2.length; i++) {
            diagonalSum1 += matrix2[i][i];
            diagonalSum2 += matrix2[i][matrix2.length - 1 - i];
        }

        boolean isMagicMatrix = diagonalSum1 == diagonalSum2;

        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                // Sum of even and odd rows
                if (i % 2 == 0) {
                    evenRowsSum += matrix2[i][j];
                } else {
                    oddRowsSum += matrix2[i][j];
                }

                // Product of even and odd columns
                if (j % 2 == 0) {
                    evenColumnsProduct *= matrix2[i][j];
                } else {
                    oddColumnsProduct *= matrix2[i][j];
                }

                if (isMagicMatrix) {
                    rowSum += matrix2[i][j];
                    columnSum += matrix2[j][i];
                }
            }

            if (!isMagicMatrix || rowSum != columnSum || rowSum != diagonalSum1) {
                isMagicMatrix = false;
            } else {
                columnSum = 0;
                rowSum = 0;
            }
        }

        System.out.println("Сума елементів у парних рядках (рядок 0, 2): " + evenRowsSum);
        System.out.println("Сума елементів у непарних рядках (рядок 1, 3): " + oddRowsSum);
        System.out.println("Добуток елементів у парних стовпцях (стовпець 0, 2): " + evenColumnsProduct);
        System.out.println("Добуток елементів у парних стовпцях (стовпець 0, 2): " + oddColumnsProduct);

        if (isMagicMatrix) {
            System.out.println("Матриця є магічним квадратом.");
        } else {
            System.out.println("Матриця не є магічним квадратом.");
        }
    }
}
