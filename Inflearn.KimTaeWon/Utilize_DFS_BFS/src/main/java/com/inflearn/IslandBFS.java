package com.inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class IslandBFS {
    static int N;
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[][] board;
    static int answer = 0;
    public static void main(String[] args) {
        IslandBFS islandBFS = new IslandBFS();

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
                    islandBFS.BFS(new Point(j, i));
                }
            }
        }

        System.out.println(answer);

    }

    private void BFS(Point point) {
        Queue<Point> queue = new LinkedList<>();

        queue.offer(point);
        while (!queue.isEmpty()) {
            Point curr = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                Point next = new Point(curr.x + dx[i], curr.y + dy[i]);
                if (next.x >= 0 && next.x < N && next.y >= 0 && next.y < N && board[next.y][next.x] == 1) {
                    board[next.y][next.x] = 0;
                    queue.offer(next);
                }
            }
        }
    }
}
