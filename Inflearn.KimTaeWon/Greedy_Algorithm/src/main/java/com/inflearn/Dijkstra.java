package com.inflearn;

import java.util.*;

public class Dijkstra {
    static ArrayList<ArrayList<Edge>> graph;
    static int n;
    static int[] dis;
    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra();

        Scanner sc = new Scanner(System.in);
        graph = new ArrayList<>();

        n = sc.nextInt();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            graph.get(a).add(new Edge(b, cost));
        }

        /**
         * 1 - (2, 12), (3, 4)
         * 2 - (1, 2), (3, 5), (5, 5)
         * 3 - (4, 5)
         * 4 - (2, 2), (5, 5)
         * 6 - (4, 5)
         */

        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        dijkstra.solution(1);
    }

    private void solution(int v) {
        PriorityQueue<Edge> pQ = new PriorityQueue<>(Comparator.naturalOrder()); // BFS와 비슷한 역할
        pQ.offer(new Edge(v, 0));
        dis[v] = 0; // 1로 도착하는 건 없으니 0
        while (!pQ.isEmpty()) {
            Edge tmp = pQ.poll();
            int nowV = tmp.v;
            int nowCost = tmp.cost;
            if (nowCost > dis[nowV]) continue; // 최소가 아니므로
            /**
             * 1 - (2, 12), (3, 4)
             * 2 - (1, 2), (3, 5), (5, 5)
             * 3 - (4, 5)
             * 4 - (2, 2), (5, 5)
             * 6 - (4, 5)
             */
            for (Edge e : graph.get(nowV)) {
                int nextCost = nowCost + e.cost;
                if (nextCost < dis[e.v]) {
                    dis[e.v] = nextCost;
                    pQ.offer(new Edge(e.v, nextCost));
                }
            }
        }
        /**
         *       0  1   2  3  4   5  6
         * dis = [, 0, 11, 4, 9, 14, ]
         * pQ (1, 0)          : tmp (1, 0) -- (2, 12) => 0 + 12 = 12 < M => dis[2] = 12
         *                                    (3, 4) => 0 + 4 = 4 < M => dis[3] = 4
         * pQ (2, 12), (3, 4)
         *                    : tmp (3, 4) -- (4, 5) => 4 + 5 = 9 < M => dis[4] = 9
         * pQ (2, 12), (4, 9)
         *                    : tmp (4, 9) -- (2, 2) => 9 + 2 = 11 < dis[2] = 12 => dis[2] = 11
         *                                    (5, 5) => 9 + 5 = 14 < dis[5] = M => dis[5] = 14
         * pQ (2, 12), (2, 11), (5, 14)
         *                    : tmp (2, 11) -- (1, 2) => 11 + 2 = 13 > dis[1] = 0
         *                                     (3, 5) => 11 + 5 = 16 > dis[3] = 4
         *                                     (5, 5) => 11 + 5 = 16 > dis[5] = 14
         * pQ (2, 12), (5, 14)
         *                    : tmp (2, 12) -- 12 > 11 continue;
         * pQ (5, 14)
         *                    : tmp (5, 14) -- null
         */
    }
}

class Edge implements Comparable<Edge> {
    int v;
    int cost;

    public Edge(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.v - o.v;
    }
}

/*
입력

6 9
1 2 12
1 3 4
2 1 2
2 3 5
2 5 5
3 4 5
4 2 2
4 5 5
6 4 5
 */