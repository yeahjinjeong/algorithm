package com.inflearn;

import java.util.Scanner;

public class StackFrame {
    public static void main(String[] args) {
        StackFrame stackFrame = new StackFrame();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        stackFrame.DFS(n);
        System.out.println();
        stackFrame.DFS2(n);
    }

    private void DFS(int n) {
        if (n==0) return;
        else {
            DFS(n-1);
            System.out.print(n + " ");
        }
    }
    // DFS(3) -> DFS(2) -> DFS(1) -> DFS(0) -> return -> 1 -> } -> 2 -> } -> 3 -> }

    private void DFS2(int n) {
        if (n==0) return;
        else {
            System.out.print(n + " "); // 3
            DFS2(n-1);
        }
    }
    // DFS(3) -> 3 -> DFS(2) -> 2 -> DFS(1) -> 1 -> DFS(0) -> return -> } -> } -> }
}
