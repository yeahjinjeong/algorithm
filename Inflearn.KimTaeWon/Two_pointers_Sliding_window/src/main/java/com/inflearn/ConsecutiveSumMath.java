package com.inflearn;

import java.util.Scanner;

public class ConsecutiveSumMath {
    public static void main(String[] args) {
        ConsecutiveSumMath consecutiveSumMath = new ConsecutiveSumMath();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        consecutiveSumMath.solution(n);

    }

    public void solution(int n) {
        int answer = 0,cnt =1;
        n--;
        while (n > 0) {
            cnt++;
            n = n - cnt;
            if (n % cnt == 0) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
