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
                    queue.offer(new Point(j, i)); // 주의! j가 x이고 i가 y
                    flag = true;
                }
            }
        } // 일단 익어있는 토마토들을 queue에 보관

        if (!flag) return 0; // 만약 익어있는 게 없다면 (1이 하나도 없다면) 익을 수 있는 것도 없다!

        int day = 0;

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
            day++; // for문이 끝나면 하루가 지난 것!

            for (int i = 0; i < n; i++) { // 다 익었나 확인!
                for (int j = 0; j < m; j++) {
                    if (box[i][j] == 0) {
                        flag = false; // 안 익은 게 있다!
                        break;
                    }
                }
            }
            if (flag) { // 다 익었다!
                return day; // 얼마만에 다 익었나!
            }
        } // while문이 종료되도록 return이 안 된거면,,
        return -1; // 절대 못 익는 위치에 토마토가 있었던 것!
    }
}