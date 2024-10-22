package com.inflearn;

import java.util.Scanner;

public class SearchPeaks {
    public static void main(String[] args) {
        SearchPeaks searchPeaks = new SearchPeaks();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = n+2;
        int[][] board = new int[k][k];
        for (int i = 0; i < k; i++) {
            board[0][i] = 0;
            board[i][0] = 0;
            board[k-1][i] = 0;
            board[i][k-1] = 0;
        }

        for (int i = 1; i < k-1; i++) {
            for (int j = 1; j < k-1; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        searchPeaks.solution(k, board);
    }

    public void solution(int k, int[][] board) {
        int sum = 0;
        for (int i = 1; i < k; i++) {
            for (int j = 1; j < k; j++) {
                if (board[i][j] > board[i-1][j] && board[i][j] > board[i][j-1] &&
                        board[i][j] > board[i+1][j] && board[i][j] > board[i][j+1]) sum++;
            }
        }
        System.out.println(sum);
    }
}
