package com.inflearn;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SeekNumberArray {
    static int n, m;
    static int[] arr, answer, visit;
    public static void main(String[] args) {
        SeekNumberArray seekNumberArray = new SeekNumberArray();

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt(); // 자릿수가 정해짐


        answer = new int[m];

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        visit = new int[n];

//        seekNumberArray.DFS(0);
        seekNumberArray.DFS2(0);
    }

    private void DFS(int L) {
        if (L == m) {
            Set<Integer> set = new HashSet<>();
            for (int i : answer) {
                set.add(i);
            }
            if (set.size() == m) {
                for (int j : answer) {
                    System.out.print(j + " ");
                }
                System.out.println();
            }
        } else {
            for (int i : arr) {
                answer[L] = i;
                DFS(L + 1);
            }
        }
    }

    private void DFS2(int L) {
        if (L == m) {
            for (int j : answer) System.out.print(j + " ");
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (visit[i] == 0) {
                    visit[i] = 1;
                    answer[L] = arr[i];
                    DFS2(L + 1);
//                    visit[i] = 0;
                }
            }
        }
    }
}
