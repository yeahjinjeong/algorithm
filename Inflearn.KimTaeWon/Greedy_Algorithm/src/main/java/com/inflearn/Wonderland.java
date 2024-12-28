package com.inflearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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
    static int[] unionAndFind;
    static int sum;
    public static void main(String[] args) {
        Wonderland wonderland = new Wonderland();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        unionAndFind = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            unionAndFind[i] = i;
        }
        int m = sc.nextInt();
        List<Kruskal> kruskals = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();
            kruskals.add(new Kruskal(v1, v2, cost));
        }

        wonderland.solution(kruskals);
        System.out.println(sum);
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