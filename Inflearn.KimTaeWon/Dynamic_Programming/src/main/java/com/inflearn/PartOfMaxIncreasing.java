package com.inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class PartOfMaxIncreasing {
    static int[] dy;
    public static void main(String[] args) {
        PartOfMaxIncreasing partOfMaxIncreasing = new PartOfMaxIncreasing();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        partOfMaxIncreasing.solution(arr);
        Arrays.sort(dy);
        System.out.println(dy[n - 1]);
    }

    private void solution(int[] arr) {
        dy = new int[arr.length];
        dy[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) { // 바로 앞부터 처음까지
                if (arr[j] < arr[i] && dy[j] > max) { // arr[i]보다 작은데, dy[j] 중 가장 큰 값을 찾음 => 작은 것들 중 가장 큰 값을 찾는 것
                    max = dy[j];
                }
            }
            dy[i] = max + 1;
        }
    }
}
/*
8
5 3 7 8 6 2 9 4
*/