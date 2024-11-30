package com.inflearn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 최단거리 = BFS
 */
public class GraphBFS {
    static int n, m;
    static int distance = 0;
    static int[][] graph;
    static int[] answer, dis;
    public static void main(String[] args) {
        GraphBFS graphBFS = new GraphBFS();

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        graph = new int[n + 1][n + 1];
        answer = new int[n + 1];

        m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
        }
        graphBFS.BFS();
        for (int a = 1; a < answer.length; a++) {
            System.out.println(a + " : " + answer[a]);
        }
    }

    private void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        answer[0] = -1;
        answer[1] = -1;
        while (Arrays.stream(answer).anyMatch(a -> a == 0)) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int cv = queue.poll();
                for (int j = 1; j <= n; j++) {
                    if (graph[cv][j] == 1) {
                        if (answer[j] == 0) answer[j] = distance+1;
                        queue.offer(j);
                    }
                }
            }
            distance++;
        }
    }
}
/*
6 9
1 3
1 4
2 1
2 5
3 4
4 5
4 6
6 2
6 5
 */