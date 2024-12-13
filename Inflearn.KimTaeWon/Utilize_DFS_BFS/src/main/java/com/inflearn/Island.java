package com.inflearn;

import java.util.Scanner;

public class Island {
    static int N;
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[][] board;
    static int answer = 0;
    public static void main(String[] args) {
        Island island = new Island();

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    answer++;
                    island.DFS(j, i);
                }
            }
        }

        System.out.println(answer);

    }

    private void DFS(int x, int y) {
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && board[ny][nx] == 1) {
                board[ny][nx] = 0;
                DFS(nx, ny);
            }
        }
    }
}
