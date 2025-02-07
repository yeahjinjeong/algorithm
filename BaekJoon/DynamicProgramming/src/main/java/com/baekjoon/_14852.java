package com.baekjoon;

import java.util.*;

public class _14852 {
    static int[] d = new int[10001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        _14852 m = new _14852();
//        System.out.print(m.dp(n));

        int[] d = new int[n + 1];
        d[0] = 1;
        d[1] = 2;
        for (int i = 2; i <= n; i++) {
            d[i] = (d[i-1]*2 + d[i-2]*3)%1000000007;
            for (int j = 2; i - j >= 0; j++) {
                if (j % 2 == 1) {
                    d[i] += (d[i - j] * 2)%1000000007;
                }
            }
        }
        System.out.print(d[n]%1000000007);
    }
    private int dp(int x) {
        if (x == 0) return 1;
        if (x == 1) return 2;
        if (x == 2) return 7;
        if (d[x] != 0) return d[x];
        int result = dp(x - 1)*2 + dp(x - 2)*3;
        for (int i = 3; i <= x; i++) {
            result += dp(x - i)*2;
        }
        return d[x] = result;
    }
}