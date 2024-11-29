package com.inflearn;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 정점의 수가 커질수록 인접행렬 풀이는 비효율적
 * => 인접리스트가 해결책이 될 수 있다!
 */
public class SearchPathArrayList {
    static int n, m;
    static int[] arr;
    static ArrayList<ArrayList<Integer>> graph;
    static int answer = 0;
    public static void main(String[] args) {
        SearchPathArrayList searchPathArrayList = new SearchPathArrayList();

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n+1];

        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }

        arr[1] =1;
        searchPathArrayList.DFS(1);

        System.out.println(answer);
    }

    private void DFS(int i) {
        if (i == n) {
            answer++;
        }
        else {
//            for (int j = 0; j < graph.get(i).size(); j++) {
//                if (arr[graph.get(i).get(j)] == 0) {
//                    arr[graph.get(i).get(j)] = 1;
//                    DFS(graph.get(i).get(j));
//                    arr[graph.get(i).get(j)] = 0;
//                }
//            }

            for (int nv : graph.get(i)) {
                if (arr[nv] == 0) {
                    arr[nv] = 1;
                    DFS(nv);
                    arr[nv] = 0;
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