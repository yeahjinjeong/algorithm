package com.inflearn;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        PrimeNumber primeNumber = new PrimeNumber();
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        System.out.println(primeNumber.solution(input));
    }

    public int solution(int n) {
        int[] check = new int[n + 1];
        int answer = 0;
        for (int i = 2; i < check.length; i++) {
            if (check[i] == 0) {
                answer++;
                for (int j = i; j < check.length; j += i)
                    check[j] = 1;
            }
        }
        return answer;
    }
}
