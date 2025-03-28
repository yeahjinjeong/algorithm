package com.inflearn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NCM {
    static int n, m;
    static int[] arr, visit;
    static int[] answer;
    public static void main(String[] args) {
        NCM ncm = new NCM();

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n + 1];
        visit = new int[n + 1];

        answer = new int[m];

//        ncm.DFS(0);
        ncm.DFS2(0, 1);

    }

    private void DFS(int L) {
        if (L == m) {
            arr[answer[0]] = 1;
            for (int a : answer) {
                System.out.print(a + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                if (visit[i] == 0 && arr[i] == 0) {
                    visit[i] = 1;
                    answer[L] = i;
                    DFS(L + 1);
                    visit[i] = 0;
                }
            }
        }
    }

    private void DFS2(int L, int f) {
        if (L == m) { // 몇개 뽑혔나
            for (int a : answer) {
                System.out.print(a + " ");
            }
            System.out.println();
        } else {
            for (int i = f; i <= n; i++) {
                answer[L] = i; // answer[0] = 1 -> DFS2(1, 2) -> answer[1] = 2 -> DFS2(1
                DFS2(L + 1, i + 1);
            }
        }
    }
}
