package com.inflearn;

import java.util.Scanner;

public class Combination {
    int[][] dy = new int[35][35];
    public static void main(String[] args) {
        Combination combination = new Combination();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt();

        System.out.println(combination.DFS(n, r));
    }

    private int DFS(int n, int r) {
        if (dy[n][r] > 0) return dy[n][r]; // 이미 구한 적 있는 조합은 다시 구할 필요가 없기 때문에
        if (n == r) return 1;
        else if (r == 1) return n;
        else return dy[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
    }
}
