package com.inflearn;

import java.util.Scanner;

public class Naughty {
    public static void main(String[] args) {
        Naughty naughty = new Naughty();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        String solution = naughty.solution(n, arr);
        System.out.print(solution);
    }

    private String solution(int n, int[] arr) {
        int lt = 0, rt = n-1;
        int CHEOLSU = 0;
        int pair = 0;
        while (CHEOLSU == 0 || pair == 0) {
            if (arr[lt] > arr[lt+1]) CHEOLSU = lt + 1;
            if (arr[rt-1] > arr[rt]) pair = rt + 1;

            lt++;
            rt--;
        }
        return CHEOLSU + " " + pair;
    }
}
