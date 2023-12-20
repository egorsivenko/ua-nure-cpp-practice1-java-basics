package ua.nure.cpp.sivenko.practice1.task;

import java.util.Comparator;

public class Part2 {
    public static void main(String[] args) {
        if (args.length < 1)
            throw new IllegalArgumentException("An integer must be passed as an argument");

        final int N = Integer.parseInt(args[0]);
        final int size = N + 15;
        final int abs = Math.abs(N) + 15;

        int[][] matrix = new int[size][size];
        generateMatrix(matrix, -abs, abs);

        System.out.println("\nMatrix before sorting: ");
        printMatrix(matrix);

        sortMatrixDescSnake(matrix);

        System.out.println("\nMatrix in the form of a vertical descending snake:");
        printMatrix(matrix);
    }

    private static void generateMatrix(int[][] matrix, int min, int max) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = (int) (Math.random() * (max - min + 1) + min);
            }
        }
    }

    private static void sortMatrixDescSnake(int[][] matrix) {
        int length = matrix.length;
        int[] temp = new int[length * length];

        for (int i = 0, k = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                temp[k++] = matrix[i][j];
            }
        }

        bubbleSort(temp, temp.length, (o1, o2) -> Integer.compare(o2, o1));

        for (int i = 0, k = 0; i < length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < length; j++) {
                    matrix[j][i] = temp[k++];
                }
            } else {
                for (int j = length - 1; j >= 0; j--) {
                    matrix[j][i] = temp[k++];
                }
            }
        }
    }

    private static void bubbleSort(int[] array, int length, Comparator<Integer> comparator) {
        boolean isSorted;
        for (int i = 0; i < length - 1; i++) {
            isSorted = true;
            for (int j = 0; j < length - i - 1; j ++)
                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    swap(array, j, j + 1);
                    isSorted = false;
                }
            if (isSorted)
                return;
        }
    }

    private static void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    private static void printMatrix(int[][] matrix) {
        if (matrix == null) return;

        for (int i = 0; i < matrix.length; i++) {
            System.out.print('[');
            for (int j = 0; j < matrix.length; j++) {
                System.out.printf("%5s", matrix[i][j]);
                if (j != matrix.length - 1)
                    System.out.print(", ");
            }
            System.out.println("\t ]");
        }
    }
}
