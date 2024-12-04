package com.inflearn;

import java.util.Scanner;

public class DogsToTruck {

    static int c, n, answer;
    static int[] arr;
    public static void main(String[] args) {
        DogsToTruck dogsToTruck = new DogsToTruck();

        Scanner sc = new Scanner(System.in);

        c = sc.nextInt();
        n = sc.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        dogsToTruck.DFS(0, 0);
        System.out.println(answer);
    }

    private void DFS(int L, int sum) {
        if (L == n) {
            if (sum <= c) {
                answer = Math.max(answer, sum);
            }
        } else {
            DFS(L + 1, sum + arr[L]);
            DFS(L + 1, sum);
        }
    }
}
