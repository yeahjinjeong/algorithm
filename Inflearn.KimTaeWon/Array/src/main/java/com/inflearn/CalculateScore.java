package com.inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class CalculateScore {
    public static void main(String[] args) {
        CalculateScore calculateScore = new CalculateScore();

        Scanner sc = new Scanner(System.in);

        int input1 = sc.nextInt();
        sc.nextLine();
        String[] input2 = sc.nextLine().split(" ");

        calculateScore.solution(input1, input2);
        calculateScore.solution2(input1, input2);
    }

    public void solution(int n, String[] input) {
        int[] arr = new int[n];
        int[] scoreArray = new int[n];
        int score = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
            if (arr[i] == 1) scoreArray[i] = ++score;
            else {
                score = 0;
                scoreArray[i] = score;
            }
        }
        System.out.println(Arrays.stream(scoreArray).sum());
    }

    public void solution2(int n, String[] input) {
        int[] arr = new int[n];
        int score = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
            if (arr[i] == 1) {
                score++;
                sum += score;
            }
            else {
                score = 0;
            }
        }
        System.out.println(sum);
    }
}
