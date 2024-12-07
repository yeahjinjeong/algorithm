package com.inflearn;

import java.util.Scanner;

public class Combination {
    public static void main(String[] args) {
        Combination combination = new Combination();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt();

        System.out.println(combination.DFS(n, r));
    }

    private int DFS(int n, int r) {
        if (n == r) return 1;
        else if (r == 1) return n;
        else return DFS(n - 1, r - 1) + DFS(n - 1, r);
    }
}
