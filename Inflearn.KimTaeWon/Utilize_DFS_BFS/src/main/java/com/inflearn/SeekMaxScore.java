package com.inflearn;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SeekMaxScore {
    static int n, m, answer;
    static Map<Integer, Integer> problem;

    public static void main(String[] args) {
        SeekMaxScore seekMaxScore = new SeekMaxScore();

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        problem = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            problem.put(a, b);
        }

        seekMaxScore.DFS(0, 0, 0);
        System.out.println(answer);
    }

    private void DFS(int L, int sum, int time) {
        if (time > m) return;
        if (L == n) {
            answer = Math.max(answer, sum);
        } else {
            int key = (int) problem.keySet().toArray()[L];
            DFS(L + 1, sum + key, time + problem.get(key));
            DFS(L + 1, sum, time);
        }
    }
}
