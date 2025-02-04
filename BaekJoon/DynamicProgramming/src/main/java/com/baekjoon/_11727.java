package com.baekjoon;

import java.util.Scanner;

public class _11727 {
    public static void main(String[] args) {
        _11727 _11727 = new _11727();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        System.out.print(_11727.dp(n));

        int[] d = new int[n + 1];
        d[0] = 1;
        d[1] = 1;
        for (int i = 2; i <= n; i++) {
            d[i] = (d[i - 1] + d[i - 2] * 2) % 10007;
        }
        System.out.print(d[n]);
    }

    // 재귀적 호출 : 시간 초과
    private int dp(int x) {
        int[] d = new int[1001];
        if ( x == 1 ) return 1;
        if ( x == 2 ) return 3;
        if (d[x] != 0) return d[x];
        return d[x] = (dp(x - 1) + dp(x - 2) * 2) % 10007;
    }
}
