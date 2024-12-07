package com.inflearn;

import java.util.Scanner;

public class PresumeNumberArray {
    static int n, f;
    static boolean flag = false;
    static boolean flag2 = false;
    static int[] top, visit;
    public static void main(String[] args) {
        PresumeNumberArray presumeNumberArray = new PresumeNumberArray();

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        f = sc.nextInt();

        top = new int[n];
        visit = new int[n];

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        presumeNumberArray.DFS(0, arr);
    }

    private void DFS2(int L, int[] arr) {
        if (flag) return;
        if (L == 1) {
            if (arr[0] == f) {
                flag = true;
            }
        } else {
            int[] newArr = new int[L - 1];
            for (int i = 0; i < L - 1; i++) {
                newArr[i] = arr[i] + arr[i + 1];
            }
            DFS2(L - 1, newArr);
        }
    }

    private void DFS(int L, int[] arr) {
        if (flag2) return;
        if (L == n) {
            DFS2(L, top);
            if (flag) {
                for (int t : top) {
                    System.out.print(t + " ");
                }
                flag2 = true;
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (visit[i] == 0) {
                    visit[i] = 1;
                    top[L] = arr[i];
                    DFS(L + 1, arr);
                    visit[i] = 0;
                }
            }
        }
    }
}
