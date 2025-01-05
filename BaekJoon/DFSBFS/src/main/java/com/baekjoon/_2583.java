package com.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _2583 {
    static int row, col, sum = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] board;
    public static void main(String[] args) {
        _2583 _2583 = new _2583();

        Scanner sc = new Scanner(System.in);
        row = sc.nextInt();
        col = sc.nextInt();

        board = new int[row + 1][col + 1];

        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            // 0 2 4 4
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    board[x][y] = 1;
                }
            }
            // board[0][2] board[0][3] board[0][4]
            // board[1][2] board[1][3] board[1][4]
            // ...
            // board[4][2] board[4][3] board[4][4]
        }

        _2583.BFS(new Point(0, 0));
        System.out.println(sum);
    }

    private void BFS(Point point) {
        Queue<Point> queue = new LinkedList<>();

        queue.offer(point);

        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int q = 0; q < qSize; q++) {
                Point cur = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    if (nx >= 0 && ny >= 0 && nx < col && ny < row && board[nx][ny] == 0) {
                        board[nx][ny] = 1;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
            sum++;
        }
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}