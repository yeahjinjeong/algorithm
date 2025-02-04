package com.baekjoon;

import java.util.Scanner;

/**
 * 2*n 크기의 직사각형을 1*2, 2*1 타일로 채우기
 */
public class _11726 {
    public static void main(String[] args) {
        _11726 _11726 = new _11726();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(_11726.dp(n));
    }

    private int dp(int x) {
        int[] d = new int[1001];
        if ( x == 1 ) return 1;
        if ( x == 2 ) return 2;
        if (d[x] != 0) return d[x];
        return d[x] = (dp(x - 1) + dp(x - 2)) % 10007;
    }
}
