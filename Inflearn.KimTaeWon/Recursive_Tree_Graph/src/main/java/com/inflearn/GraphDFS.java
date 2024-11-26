package com.inflearn;

import java.util.Scanner;

public class GraphDFS {
    static int n, m;
    static int[] arr;
    static int[][] graph;
    static int answer = 0;
    public static void main(String[] args) {
        GraphDFS graphDFS = new GraphDFS();

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n+1];
        graph = new int[n+1][n+1];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
        }

        arr[1] = 1;
        graphDFS.DFS(1);
        System.out.println(answer);
    }

    private void DFS(int num) {
        if (num == n) answer++; // 5까지 왔을 때
        else {
            for (int i = 1; i <= n; i++) {
                if (graph[num][i] == 1 && arr[i] == 0) {
                    arr[i] = 1;
                    DFS(i);
                    arr[i] = 0;
                }
            }
        }
    }
}

/*
5 9
1 2
1 3
1 4
2 1
2 3
2 5
3 4
4 2
4 5
 */