package com.inflearn;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SeekNumberArray {
    static int n, m;
    static int[] arr, answer;
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

        seekNumberArray.DFS(0);
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
}
