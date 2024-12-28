package com.inflearn;

import java.util.*;

/**
 * 그래프와 트리의 차이점
 *  - 그래프 : 순환
 *  - 트리 : 비순환
 *  트리는 간선이 (정점 - 1)개
 *
 *  크루스칼 알고리즘 *
 *
 */
public class Wonderland {
    static int n, m;
    // solution
    static int[] unionAndFind;
    static int sum = 0;
    // solution2
    static int[] check;
    static int sum2 = 0;

    public static void main(String[] args) {
        Wonderland wonderland = new Wonderland();

        Scanner sc = new Scanner(System.in);

        // 1
        n = sc.nextInt();
        unionAndFind = new int[n + 1];
        // 2
        ArrayList<ArrayList<Prim>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            unionAndFind[i] = i;
            graph.add(new ArrayList<>());
        }

        m = sc.nextInt();

        List<Kruskal> kruskals = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();
            kruskals.add(new Kruskal(v1, v2, cost));
            graph.get(v1).add(new Prim(v2, cost));
            graph.get(v2).add(new Prim(v1, cost));
        }

        wonderland.solution(kruskals);
        System.out.println(sum);

        wonderland.solution2(graph);
        System.out.println(sum2);
    }

    private void solution(List<Kruskal> kruskals) {
        Collections.sort(kruskals);
        for (Kruskal k : kruskals) {
            union(k);
        }
    }


    private static int find(int v) {
        if (v == unionAndFind[v]) return v;
        else return unionAndFind[v] = find(unionAndFind[v]);
    }

    private static void union(Kruskal kruskal) {
        int fa = find(kruskal.v1);
        int fb = find(kruskal.v2);
        if (fa == fb) return;
        unionAndFind[fa] = fb;
        sum += kruskal.cost;
    }

    /**
     * 무방향 인접 리스트
     * @param graph
     *
     * 프림 알고리즘 *
     */

    private void solution2(ArrayList<ArrayList<Prim>> graph) {
        PriorityQueue<Prim> pQ = new PriorityQueue<>(Comparator.naturalOrder());
        check = new int[n + 1];
        pQ.offer(new Prim(1, 0));
        while (!pQ.isEmpty()) {
            Prim tmp = pQ.poll();
            if (check[tmp.v] == 0) {
                check[tmp.v] = 1;
                sum2 += tmp.cost;
                for (Prim p : graph.get(tmp.v)) {
                    if (check[p.v] == 0) pQ.offer(p);
                }
            }
        }
    }
}

class Kruskal implements Comparable<Kruskal> {
    int v1;
    int v2;
    int cost;

    public Kruskal(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Kruskal o) {
        return this.cost - o.cost;
    }
}

class Prim implements Comparable<Prim> {
    int v;
    int cost;

    public Prim(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }

    @Override
    public int compareTo(Prim o) {
        return this.cost - o.cost;
    } // 이건 sort를 안해줘도 add될 때 자동정렬이 되는 것일까? => 아니다. 다만 PriorityQueue안에서는 cost 순위로 정렬이 될 것.
}