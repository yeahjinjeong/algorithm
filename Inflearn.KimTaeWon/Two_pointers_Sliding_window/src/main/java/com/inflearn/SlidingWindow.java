package com.inflearn;

import java.util.Scanner;

public class SlidingWindow {
    public static void main(String[] args) {
        SlidingWindow slidingWindow = new SlidingWindow();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] sales = new int[n];
        for (int i = 0; i < n; i++) {
            sales[i] = sc.nextInt();
        }
        slidingWindow.solution(n, k, sales);
        slidingWindow.solution2(n, k, sales);
    }

    // time limit exceed
    private void solution(int n, int k, int[] sales) {
        int sum = 0;
        int max = 0;
        int i = 0;
        while (i < n - k) {
            for (int j = i; j < i + k; j++) {
                sum += sales[j];
            }
            if (sum > max) {
                max = sum;
            }
            sum = 0;
            i++;
        }
        System.out.println(max);
    }

    private void solution2(int n, int k, int[] sales) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += sales[i];
        }
        int max = sum;
        for (int i = k; i < n; i++) {
            sum = sum + sales[i] - sales[i-k];
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}
