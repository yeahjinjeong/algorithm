package com.inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tomato {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int m, n;
    static int[][] box;
    public static void main(String[] args){
        Tomato tomato = new Tomato();

        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        box = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                box[i][j] = sc.nextInt();
            }
        }

        System.out.println(tomato.BFS());
    }

    private int BFS() {

        Queue<Point> queue = new LinkedList<>();
        boolean flag = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 1) {
                    queue.offer(new Point(j, i));
                    flag = true;
                }
            }
        }

        if (!flag) return 0;

        int distance = 0;

        while (!queue.isEmpty()) {
            flag = true;

            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                Point curr = queue.poll();
                for (int j = 0; j < 4; j++) {
                    Point next = new Point(curr.x + dx[j], curr.y + dy[j]);
                    if (next.x >= 0 && next.x < m
                            && next.y >= 0 && next.y < n
                            && box[next.y][next.x] == 0) {
                        box[next.y][next.x] = 1;
                        queue.offer(next);
                    }
                }
            }
            distance++;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (box[i][j] == 0) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                return distance;
            }
        }
        return -1;
    }
}