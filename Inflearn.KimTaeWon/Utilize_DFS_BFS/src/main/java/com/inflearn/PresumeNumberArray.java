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

        presumeNumberArray.arrayDFS(0, arr);
    }

    private void makePascal(int L, int[] arr) {
        if (flag) return;
        if (L == 1) {
            if (arr[0] == f) {
                flag = true; // 결과가 주어진 수(f)와 일치함을 뜻함
            }
        } else {
            int[] newArr = new int[L - 1];
            for (int i = 0; i < L - 1; i++) {
                newArr[i] = arr[i] + arr[i + 1];
            }
            makePascal(L - 1, newArr);
        }
    }

    private void arrayDFS(int L, int[] arr) {
        if (flag2) return;
        if (L == n) {
            makePascal(L, top);
            if (flag) {
                for (int t : top) {
                    System.out.print(t + " ");
                }
                flag = false;
                flag2 = true; // 첫번째 답만 출력하고자 함
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (visit[i] == 0) {
                    visit[i] = 1;
                    top[L] = arr[i];
                    arrayDFS(L + 1, arr);
                    visit[i] = 0;
                }
            }
        }
    }
}
