package com.inflearn;

import java.util.Scanner;

/**
 *
 * 3 1 2 4
 * 3+1 1+2 2+4
 * 3+1+1+2 1+2+2+4
 * 3+1+1+2+1+2+2+4
 *
 * 3+1+1+1+2+2+2+4
 *
 * 3 * 1 = 3C0
 * 1 * 3 = 3C1
 * 2 * 3 = 3C2
 * 4 * 1 = 3C3
 *
 * x * 3C0 + y * 3C1 + z * 3C2 + r * 3C3 = 16 이 성립해야 한다
 *
 */

public class PresumeNumberArray2 {
    static int N, f;
    static int[] top, visit;
    static boolean flag = false;
    static int[][] pascal;
    public static void main(String[] args) {
        PresumeNumberArray2 presumeNumberArray = new PresumeNumberArray2();

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        f = sc.nextInt();

        top = new int[N];
        visit = new int[N + 1];
        pascal = new int[N][N];

        presumeNumberArray.DFS(0, 0);
    }

    private void DFS(int L, int sum) {
        if (flag) return;
        if (L == N) {
            if (sum == f) {
                for (int t : top) System.out.print(t + " ");
                flag = true;
            }
        } else {
            for (int i = 1; i <= N; i++) {
                if (visit[i] == 0) {
                    visit[i] = 1;
                    top[L] = i;
                    DFS(L + 1, sum + top[L] * DFS2(N - 1, L));
                    visit[i] = 0;
                }
            }
        }
    }

    private int DFS2(int n, int r) {
        if (pascal[n][r] != 0) return pascal[n][r];
        if (n == r || r == 0) return 1;
        if (r == 1) return n;
        else {
            return pascal[n][r] = DFS2(n - 1, r - 1) + DFS2(n - 1, r);
        }
    }
}
