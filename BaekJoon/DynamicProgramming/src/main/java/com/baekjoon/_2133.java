package com.baekjoon;

import java.util.Scanner;

public class _2133 {
    static int[] d = new int[1001];
    public static void main(String[] args) {
        _2133 _2133 = new _2133();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.print(_2133.dp(n));
    }

    private int dp(int x) {
        if (x == 0) return 1;
        if (x == 1) return 0;
        if (x == 2) return 3;
        if (d[x] != 0) return d[x];
        int result = 3 * dp(x - 2);
        for (int i = 3; i <= x; i++) {
            if (i % 2 == 0) {
                result += 2 * dp(x - i); // x - 4 , x - 6, x - 8 , ...
            }
        }
        return d[x] = result;
    }
}
