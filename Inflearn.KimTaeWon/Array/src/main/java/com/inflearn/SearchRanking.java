package com.inflearn;

import java.util.Scanner;

public class SearchRanking {
    public static void main(String[] args) {
        SearchRanking searchRanking = new SearchRanking();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        searchRanking.solution(n, arr);
    }

    public void solution(int n, int[] arr) {
        for (int i = 0; i < n; i++) {
            int rank = 1;
            for (int j = 0; j < n; j++) {
                if (arr[j] > arr[i]) rank++;
            }
            System.out.print(rank + " ");
        }
    }
}
