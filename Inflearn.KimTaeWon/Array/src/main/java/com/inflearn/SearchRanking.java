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
            } // j가 몇 번째로 큰지 rank에 기록
            System.out.print(rank + " ");
        }
    }
}
