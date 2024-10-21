package com.inflearn;

import java.util.Scanner;

public class MaxSumGrid {
    public static void main(String[] args) {
        MaxSumGrid maxSumGrid = new MaxSumGrid();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        maxSumGrid.solution(n, grid);
    }

    public void solution(int n, int[][] grid) {
        int max = 0;
        int rowSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowSum += grid[i][j];
            }
            if (rowSum > max) {
                max = rowSum;
            }
            rowSum = 0;
        }

        int columnSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                columnSum += grid[j][i];
            }
            if (columnSum > max) {
                max = columnSum;
            }
            columnSum = 0;
        }

        int crossSum = 0;

        for (int i = 0; i < n; i++) {
            crossSum += grid[n-i-1][i];
        }
        if (crossSum > max) {
            max = crossSum;
        }

        crossSum = 0;

        for (int i = 0; i < n ; i++) {
            crossSum += grid[i][i];
        }
        if (crossSum > max) {
            max = crossSum;
        }

        System.out.println(max);
    }
}
