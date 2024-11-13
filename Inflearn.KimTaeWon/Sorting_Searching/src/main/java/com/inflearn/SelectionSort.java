package com.inflearn;

import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i : selectionSort.solution(n, arr)) {
            System.out.print(i + " ");
        };
    }

    private int[] solution(int n, int[] arr) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }
}
