package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class _1725 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 2];
        for (int i = 1; i < n+1; i++) {
            arr[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int ans = 0;
        for (int i = 1; i < n + 2; i++) {
            while (!stack.isEmpty()) {
                int top = stack.peek();
                if (arr[top] <= arr[i]) break;
                stack.pop();
                ans = Math.max(ans, arr[top] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        System.out.println(ans);

    }
}
