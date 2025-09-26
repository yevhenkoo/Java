package org.example;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Екземпляр класу Scanner
        try {
            System.out.print("Input number of rows (M): ");
            int rows = scanner.nextInt();

            System.out.print("Input number of columns (N): ");
            int cols = scanner.nextInt();

            // Генеруємо дві матриці
            int[][] matrixA = generateMatrix(rows, cols);
            int[][] matrixB = generateMatrix(rows, cols);

            System.out.println("Matrix A:");
            printMatrix(matrixA);

            System.out.println("Matrix B:");
            printMatrix(matrixB);

            // Додаємо матриці
            int[][] matrixC = addMatrix(matrixA, matrixB);
            System.out.println("Matrix C = (A + B):");
            printMatrix(matrixC);

            // Обчислюємо суму max/min елементів
            sumMaxMinElements(matrixC);

        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter a valid integer.");
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static int[][] generateMatrix(int rows, int cols) {

        Random random = new Random(); // Екземпляр класу Random
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(-100, 100); // випадкові числа для заповнення матриці
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.printf("%5d", element);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[][] addMatrix(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            throw new IllegalArgumentException("Matrices must have the same dimensions");
        }
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    public static void sumMaxMinElements(int[][] matrix) {
        int sum = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int j = 0; j < cols; j++) {
            int value = matrix[0][j];

            for (int i = 1; i < rows; i++) {
                if ((j + 1) % 2 == 0) { // парний стовпець (індексація з 1)
                    if (matrix[i][j] > value) {
                        value = matrix[i][j];
                    }
                } else { // непарний стовпець
                    if (matrix[i][j] < value) {
                        value = matrix[i][j];
                    }
                }
            }
            sum += value;
        }

        System.out.println("Sum of max elements in even columns and min in odd columns: " + sum);
    }
}