package com.inflearn;

import java.util.Scanner;

public class IsThisFriend {
    static int[] unionAndFind; // index번 학생의 집합 번호 value
    public static void main(String[] args) {
        IsThisFriend isThisFriend = new IsThisFriend();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        unionAndFind = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            unionAndFind[i] = i;
        }

        int m = sc.nextInt();
        for (int i = 1; i <= m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            union(a, b); // 한 집합으로 만들자
        }

        int a = sc.nextInt();
        int b = sc.nextInt();
        int fa = find(a);
        int fb = find(b);
        if (fa == fb) System.out.println("YES");
        else System.out.println("NO");

    }

    private static int find(int v) {
        if (v == unionAndFind[v]) return v; // key value가 같을 때 그대로 반환
        else return unionAndFind[v] = find(unionAndFind[v]); // unionAndFind[v]에 초기화함으로써 경로압축 효과가 일어나 시간복잡도가 줄어든다
    }

    private static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) unionAndFind[fa] = fb; // a번 학생의 집합번호와 b번 학생의 집합번호가 달랐을 때, 같도록 연결
    }
}
