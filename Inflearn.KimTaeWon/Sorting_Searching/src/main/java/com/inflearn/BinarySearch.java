package com.inflearn;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 이분검색으로 인덱스 찾기
 */

public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(binarySearch.solution(n, m, arr));

        Arrays.sort(arr);
        System.out.print(Arrays.binarySearch(arr, m) + 1);
    }

    private int solution(int n, int m, int[] arr) {
        Arrays.sort(arr);

        int lt = 0, rt = n-1;
        int mid = 0;
        while (lt <= rt) {
            mid = (lt + rt) / 2;
            if (arr[mid] == m) {
                return mid + 1;
            } else if (arr[mid] < m) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        return mid + 1;
    }
}
