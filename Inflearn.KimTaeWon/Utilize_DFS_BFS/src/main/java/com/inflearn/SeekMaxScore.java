package com.inflearn;

import java.util.Scanner;

public class SeekMaxScore {
    static int n, m, answer;
    static int[] score, time;

    public static void main(String[] args) {
        SeekMaxScore seekMaxScore = new SeekMaxScore();

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        score = new int[n];
        time = new int[n];

        for (int i = 0; i < n; i++) {
            score[i] = sc.nextInt();
            time[i] = sc.nextInt();
        }

        seekMaxScore.DFS(0, 0, 0);
        System.out.println(answer);
    }

    private void DFS(int L, int scoreSum, int timeSum) {
        if (timeSum > m) return;
        if (L == n) {
            answer = Math.max(answer, scoreSum);
        } else {
            DFS(L + 1, scoreSum + score[L], timeSum + time[L]);
            DFS(L + 1, scoreSum, timeSum);
        }
    }
}
