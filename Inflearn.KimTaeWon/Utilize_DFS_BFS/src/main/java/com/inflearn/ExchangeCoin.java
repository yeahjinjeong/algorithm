package com.inflearn;

import java.util.Scanner;

public class ExchangeCoin {
    static int n, m, answer = Integer.MAX_VALUE;
    static int[] coin;
    public static void main(String[] args) {
        ExchangeCoin exchangeCoin = new ExchangeCoin();

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        coin = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            coin[i] = sc.nextInt();
        }
        m = sc.nextInt();

        exchangeCoin.DFS(0, 0);
        System.out.println(answer);
    }

    private void DFS(int L, int sum) {
        if (sum > m) return;
        if (sum == m) {
            answer = Math.min(answer, L);
        } else {
            for (int c : coin) {
                DFS(L + 1, sum + c);
            }
        }
    }
}
