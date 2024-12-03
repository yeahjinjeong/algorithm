package com.inflearn;

import java.util.*;

/**
 * 최단거리 = BFS
 */
public class AllShortestBFS {
    static int n, m;
    static int distance = 0;
    static int[][] graph;
    static int[] answer, visit;

    private void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        answer[0] = -1;
        answer[1] = -1;
        while (!queue.isEmpty()) { // queue에 중복되지 않은 정점들만 들어올 것
            for (int s = 0; s < queue.size(); s++) { // 한 레벨씩 돌면서 필터링 하는 느낌
                int cv = queue.poll();
                for (int nv = 1; nv <= n; nv++) {
                    if (graph[cv][nv] == 1 && visit[nv] == 0) { // 방문 여부 추가
                        visit[nv] = 1; // 방문한 적 있으면 이미 큐에 추가되어서 최단 거리로 나올 수 있는 경우의 수는 다 나옴
                        if (answer[nv] == 0) answer[nv] = distance + 1; // 제일 먼저 나오는대로 초기화하기
                        queue.offer(nv); // 가리킴 당하는 정점이 큐에 추가됨 -> 그러나 가리키는 것이 없다면 삭제됨
                    }

//                    if (graph[cv][nv] == 1) { // 방문 여부 X = 중복 여부 X
//                        if (answer[nv] == 0) answer[nv] = distance + 1; // 제일 먼저 나오는대로 초기화하기
//                        queue.offer(nv); // 가리킴 당하는 정점이 큐에 추가됨 -> 그러나 가리키는 것이 없다면 삭제됨
//                    } => 이 방식을 쓰려면 while (Arrays.stream(answer).anyMatch(a -> a == 0)) 이렇게 조건문을 써주어야 함

                }
            }
            distance++;
        }
    }

    static ArrayList<ArrayList<Integer>> graph2;
    static int[] answer2, visit2;

    private void BFS2() {
        Queue<Integer> queue = new LinkedList<>();
        answer2[1] = 0;
        queue.add(1);
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                int cv = queue.poll();
                for (int nv : graph2.get(cv)) {
                    if (visit2[nv] == 0) {
                        visit2[nv] = 1; // 방문한 적 있으면 방문했을 때 이미 최단거리가 결정났겠으므로
                        answer2[nv] = answer2[cv] + 1;
                        queue.offer(nv);
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
        visit2 = new int[n + 1];

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