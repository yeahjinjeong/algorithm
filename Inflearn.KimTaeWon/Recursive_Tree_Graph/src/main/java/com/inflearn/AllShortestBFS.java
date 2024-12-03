package com.inflearn;

import java.util.*;

/**
 * 최단거리 = BFS
 */
public class AllShortestBFS {
    static int n, m;
    static int distance = 0;
    static int[][] graph;
    static int[] answer;

    private void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        answer[0] = -1;
        answer[1] = -1;
        while (Arrays.stream(answer).anyMatch(a -> a == 0)) { // answer 배열이 다 채워지는 순간 종료
            for (int s = 0; s < queue.size(); s++) { // 한 레벨씩 돌면서 필터링 하는 느낌
                int cv = queue.poll();
                for (int j = 1; j <= n; j++) {
                    if (graph[cv][j] == 1) {
                        if (answer[j] == 0) answer[j] = distance + 1; // 제일 먼저 나오는대로 초기화하기
                        queue.offer(j); // 가리킴 당하는 정점이 큐에 추가됨 -> 그러나 가리키는 것이 없다면 삭제됨
                    }
                }
            }
            distance++;
        }
    }

    static ArrayList<ArrayList<Integer>> graph2;
    static int[] answer2, visit;

    private void BFS2() {
        Queue<Integer> queue = new LinkedList<>();
        answer2[1] = 0;
        queue.add(1);
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                int cv = queue.poll();
                for (int nv : graph2.get(cv)) {
                    if (visit[nv] == 0) {
                        visit[nv] = 1;
                        queue.offer(nv);
                        answer2[nv] = answer2[cv] + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        AllShortestBFS allShortestBFS = new AllShortestBFS();

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        graph = new int[n + 1][n + 1];
        graph2 = new ArrayList<>();
        for (int i = 0; i <= n; i++) { // 1부터 시작할 것이기 때문에 n까지 추가해 놓기
            graph2.add(new ArrayList<>());
        }

        answer = new int[n + 1];
        answer2 = new int[n + 1];

        visit = new int[n + 1];

        m = sc.nextInt();

        for (int i = 0; i < m; i++) { // m번
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph2.get(a).add(b);
        }

        allShortestBFS.BFS();
        for (int a = 2; a < answer.length; a++) {
            System.out.println(a + " : " + answer[a]);
        }

        allShortestBFS.BFS2();
        for (int a = 2; a < answer2.length; a++) {
            System.out.println(a + " : " + answer2[a]);
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