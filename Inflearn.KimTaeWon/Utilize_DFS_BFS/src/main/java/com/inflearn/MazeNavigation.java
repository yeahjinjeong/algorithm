package com.inflearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MazeNavigation {
    static int[][] board;
    // 상 하 좌 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int answer = 0;
    public static void main(String[] args) {
        MazeNavigation mazeNavigation = new MazeNavigation();

        Scanner sc = new Scanner(System.in);

        board = new int[8][8];

        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        board[1][1] = 1;
        mazeNavigation.DFS(1, 1);
        System.out.println(answer);

    }

    private void DFS(int x, int y) {
        if (x == 7 && y == 7) answer++;
        else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx > 0 && ny > 0 && nx < 8 && ny < 8 && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    DFS(nx, ny);
                    board[nx][ny] = 0;
                }
            }
        }
    }
}