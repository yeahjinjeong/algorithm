package com.inflearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MazeNavigation {
    static int[][] board, visit;
    static int answer = 0;
    static List<int[][]> ca;
    public static void main(String[] args) {
        MazeNavigation mazeNavigation = new MazeNavigation();

        Scanner sc = new Scanner(System.in);

        board = new int[8][8];
        visit = new int[8][8];
        ca = new ArrayList<>();

        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        mazeNavigation.DFS(1, 1);
        System.out.println(answer);

    }

    private void DFS(int x, int y) {
        if (x == 0 || y == 0 || x == 8 || y == 8) return;
        if (x == 7 && y == 7) {
            answer++;
        }
        if (board[x][y] == 0 && visit[x][y] == 0) {
            visit[x][y] = 1;
            DFS(x - 1, y);
            DFS(x + 1, y);
            DFS(x, y - 1);
            DFS(x, y + 1);
            visit[x][y] = 0;
        }
    }
}