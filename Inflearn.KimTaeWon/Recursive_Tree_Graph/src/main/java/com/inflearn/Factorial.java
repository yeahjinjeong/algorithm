package com.inflearn;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Factorial  factorial = new Factorial();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(factorial.DFS(n));
    }

    private int DFS(int n) {
        if (n==1) return 1;
        else return n * DFS(n - 1);
    }
    // DFS(5) -> 5 * DFS(4) -> 5 * 4 * DFS(3) -> 5 * 4 * 3 * DFS(2) -> 5 * 4 * 3 * 2 * DFS(1) -> 5 * 4 * 3 * 2 * 1
}
