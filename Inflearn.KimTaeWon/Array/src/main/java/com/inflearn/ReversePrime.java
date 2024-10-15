package com.inflearn;

import java.util.Scanner;

public class ReversePrime {
    public static void main(String[] args) {
        ReversePrime reversePrime = new ReversePrime();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String[] strings = sc.nextLine().split(" ");

        System.out.println(reversePrime.solution(n, strings));
    }

    public String solution(int n, String[] strings) {
        int[] reversed = new int[n];
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder(strings[i]);
            reversed[i] = Integer.parseInt(sb.reverse().toString());

            if (check(reversed[i])) {
                answer.append(reversed[i]);
                answer.append(" ");
            }
        }
        return answer.toString();
    }

    public boolean check(int reversed) {
        if (reversed == 1) return false;
        for (int j = 2; j < reversed; j++) {
            if (reversed % j == 0) { // 소수가 아니라면 바로 넘겨!
                return false;
            }
        }
        return true;
    }
}
