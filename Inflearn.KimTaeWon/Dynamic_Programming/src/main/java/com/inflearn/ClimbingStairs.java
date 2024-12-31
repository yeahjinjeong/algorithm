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
