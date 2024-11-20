package com.inflearn;

import java.util.Scanner;

public class Fibonacci {
    static int[] fibo; // 성능개선 (1)

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fibo = new int[n + 1];
        fibonacci.DFS(n);

        for (int i = 1; i <= n; i++) {
            System.out.print(fibonacci.DFS(i) + " ");
        }

        System.out.println();

        for (int i = 1; i <= n; i++) {
            System.out.print(fibo[i] + " ");
        }
    }

    private int DFS(int n) {
        if (fibo[n] > 0) return fibo[n]; // 성능개선 (2)
        if (n == 1) return fibo[1] = 1;
        else if (n == 2) return fibo[2] = 1;
        else return fibo[n] = DFS(n - 2) + DFS(n - 1); // n을 인덱스 삼아!
    }
    // n이 커질수록 오래걸린다!

    // 성능 : 재귀 < for문!
    // 재귀는 스택프레임이 엄청 생긴다
}
