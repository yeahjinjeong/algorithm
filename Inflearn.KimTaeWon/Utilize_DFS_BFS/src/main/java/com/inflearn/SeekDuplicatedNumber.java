package com.inflearn;

import java.util.Scanner;

public class SeekDuplicatedNumber {
    static int n, m;
    static int[] arr;
    public static void main(String[] args) {
        SeekDuplicatedNumber seekDuplicatedNumber = new SeekDuplicatedNumber();

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];

        seekDuplicatedNumber.DFS(0);
    }

    private void DFS(int L) {
        if (L == m) {
            for (int j : arr) System.out.print(j + " ");
            System.out.println();
        } else {
            for (int j = 1; j <= n; j++) {
                arr[L] = j;
                DFS(L + 1);
            }
        }
    }


}
