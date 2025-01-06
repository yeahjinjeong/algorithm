package com.baekjoon;

import java.util.*;

public class _2583 {
    static int row, col, area = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] board;
    public static void main(String[] args) {
        _2583 _2583 = new _2583();

        Scanner sc = new Scanner(System.in);
        row = sc.nextInt();
        col = sc.nextInt();

        board = new int[row][col];

        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            // 0 2 4 4
            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    board[y][x] = 1;
                }
            }
            // board[0][2] board[0][3]
            // board[1][2] board[1][3]
            // ...
            // board[4][2] board[4][3]
        }

        int sum = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = 1;
                    _2583.DFS(j, i);
                    sum++;
                    list.add(area);
                    area = 0;
                }
            }
        }

        System.out.println(sum);
        Collections.sort(list);
        for (int l : list) {
            System.out.print(l + " ");
        }
    }

    private void DFS(int x, int y) {
        area++;
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < col && ny >= 0 && ny < row && board[ny][nx] == 0) {
                board[ny][nx] = 1;
                DFS(nx, ny);
            }
        }
    }
}