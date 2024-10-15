package com.inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();

        fibonacci.solution(input);
        fibonacci.solution2(input);
    }

    public void solution(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }
        String answer = Arrays.toString(arr).replaceAll(",", "");
        System.out.println(answer.substring(1, answer.length()-1));
    }

    public void solution2(int n) {
        int a = 1, b = 1, c;
        System.out.print(a + " " + b + " ");
        for (int i = 2; i < n; i++) {
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }
}
