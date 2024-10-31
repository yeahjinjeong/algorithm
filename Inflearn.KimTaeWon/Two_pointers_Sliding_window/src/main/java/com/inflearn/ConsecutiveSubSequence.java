package com.inflearn;

import java.util.Scanner;

public class ConsecutiveSubSequence {
    public static void main(String[] args) {
        ConsecutiveSubSequence consecutiveSubSequence = new ConsecutiveSubSequence();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        consecutiveSubSequence.solution(n, sum, arr);
    }

    private void solution(int n, int sum, int[] arr) {
        int lt = 0, answer = 0, tempSum = 0;
        for (int rt = 0; rt < n; rt++) {
            tempSum += arr[rt];
            if (tempSum == sum) {
                answer++;
            }
            while (tempSum >= sum) {
                tempSum -= arr[lt++];
                if (tempSum == sum) {
                    answer++;
                }
            }
        }
//        while (rt < n) {
//            if (tempSum < sum) {
//                rt++;
//                tempSum += arr[rt];
//            } else if (tempSum == sum) {
//                answer++;
//                lt++;
//                tempSum -= arr[lt];
//            } else {
//                lt++;
//                tempSum -= arr[lt];
//            }
//        }
        System.out.println(answer);
    }
}
