package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2667 {
    static int n;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] board;
    static int[][] visit;
    public static void main(String[] args) throws IOException {
        _2667 _2667 = new _2667();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);

        n = Integer.parseInt(br.readLine());
//        n = sc.nextInt();
        board = new boolean[n][n];
        visit = new int[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
//            String s = sc.next();
            for (int j = 0; j < n; j++) {
                board[i][j] = s.charAt(j) == '1';
            }
        }

        _2667.DFSSolution();
    }

    private void DFSSolution() {
        PriorityQueue<Integer> answer = new PriorityQueue<>();

        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] && visit[i][j] == 0) {
                    answer.add(DFS(i, j, num));
                    num++;
                }
            }
        }

        System.out.println(num - 1);
//        for (int a : answer) {
//            System.out.println(a);
//        } // 백준에서 이게 틀렸습니다로 나옴
        while (!answer.isEmpty()) {
            System.out.println(answer.poll());
        }
    }

    private int DFS(int y, int x, int num) {
        visit[y][x] = num;
        int area = 1;
        for (int i = 0; i < dx.length; i++) {
            int ny = y  + dy[i];
            int nx = x  + dx[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[ny][nx] && visit[ny][nx] == 0) {
                area += DFS(ny, nx, num);
            }
        }
        return area;
    }
}