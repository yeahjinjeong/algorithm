package com.inflearn;

import java.util.Scanner;

public class SearchPeaks {
    public static void main(String[] args) {
        SearchPeaks searchPeaks = new SearchPeaks();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt() + 2;

        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            board[0][i] = 0;
            board[i][0] = 0;
            board[n-1][i] = 0;
            board[i][n-1] = 0;
        }

        for (int i = 1; i < n-1; i++) {
            for (int j = 1; j < n-1; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        searchPeaks.solution(n, board);
        searchPeaks.solution2(n, board);
    }

    public void solution(int n, int[][] board) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (board[i][j] > board[i-1][j] && board[i][j] > board[i][j-1] &&
                        board[i][j] > board[i+1][j] && board[i][j] > board[i][j+1]) sum++;
            }
        }
        System.out.println(sum);
    }

    public void solution2(int n, int[][] board) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int sum = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                boolean flag = true;
                for (int k = 0; k < dx.length; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (board[i][j] <= board[nx][ny]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) sum++;
            }
        }
        System.out.println(sum);
    }
}
