package com.baekjoon;

import java.util.*;

public class _2667 {
    static int n;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int area = 0;
    static int[][] board;
    public static void main(String[] args) {
        _2667 _2667 = new _2667();

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        int num = 2;

        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    board[i][j] = num;
                    _2667.DFS(i, j, num);
                    num++;
                    answer.add(area);
                    area = 0;
                }
            }
        }

        System.out.println(answer.size());
        Collections.sort(answer);
        for (int a : answer) {
            System.out.println(a);
        }
    }

    private void DFS(int y, int x, int num) {
        area++;
        for (int i = 0; i < dx.length; i++) {
            int ny = y  + dy[i];
            int nx = x  + dx[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[ny][nx] == 1) {
                board[ny][nx] = num;
                DFS(ny, nx, num);
            }
        }
    }
}
