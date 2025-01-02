package com.inflearn;

import java.util.Scanner;

public class ClimbingStairs {
    static int N, answer = 0;
    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        climbingStairs.DFS(0);

        System.out.println(answer);
        System.out.println(climbingStairs.solution());
    }

    /**
     * 1번째 계단까지 오는 경우의 수 1
     * 2번째 계단으로 오는 경우의 수 2 = 바닥에서 오거나, 1번째 계단에서 오거나
     * 3번째 계단으로 오는 경우의 수 3 = 1번째 계단에서 오거나, 2번째 계단에서 오거나
     * ...
     * n번째 계단으로 오는 경우의 수 = n-2번째 계단에서 오거나, n-1번째 계단에서 오거나
     * 따라서 n-2번째 경우의 수 + n-1번째 경우의 수 = n번째 경우의 수
     * => 피보나치 수열
     */

    private int solution() {
        int[] dy = new int[N + 1];

        dy[1] = 1;
        dy[2] = 2;

        for (int i = 3; i <= N; i++) {
            dy[i] = dy[i - 2] + dy[i - 1];
        }

        return dy[N];
    }

    private void DFS(int i) {
        if (i > N) return;
        if (i == N) {
            answer++;
        } else {
            DFS(i + 1);
            DFS(i + 2);
        }
    }
}
