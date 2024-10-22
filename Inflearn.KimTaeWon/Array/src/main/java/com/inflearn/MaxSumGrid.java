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
        int columnSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowSum += grid[i][j];
                columnSum += grid[j][i];
            }
            max = Math.max(max, rowSum);
            max = Math.max(max, columnSum);
            rowSum = 0;
            columnSum = 0;
        }

        int crossSum = 0;
        int crossSum2 = 0;

        for (int i = 0; i < n; i++) {
            crossSum += grid[n-i-1][i];
            crossSum2 += grid[i][i];
        }
        max = Math.max(max, crossSum);
        max = Math.max(max, crossSum2);

        System.out.println(max);
    }
}
