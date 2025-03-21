package com.inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TheShortestMazeNavigation {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] board = new int[8][8];

    public static void main(String[] args) {
        TheShortestMazeNavigation theShortestMazeNavigation = new TheShortestMazeNavigation();

        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        System.out.println(theShortestMazeNavigation.BFS(new Point(1, 1), new Point(7, 7)));
    }

    private int BFS(Point start, Point end) {
        Queue<Point> queue = new LinkedList<>();
        int distance = 0;

        queue.offer(start);

        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int q = 0; q < qSize; q++) { // 병렬적으로 계산함
                Point cur = queue.poll();
                for (int i = 0; i < 4; i++) {
                    Point next = new Point(cur.x + dx[i], cur.y + dy[i]);
                    if (next.x == end.x && next.y == end.y) return distance + 1;
                    if (next.x >= 1 && next.x <= 7 && next.y >= 1 && next.y <= 7 && board[next.x][next.y] == 0) {
                        board[next.x][next.y] =  1;
                        queue.offer(next);
                    }
                }
            }
            distance++;
        }

        return -1;
    }
}