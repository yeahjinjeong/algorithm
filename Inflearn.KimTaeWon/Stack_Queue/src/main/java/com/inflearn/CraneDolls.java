package com.inflearn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class CraneDolls {
    public static void main(String[] args) {
        CraneDolls craneDolls = new CraneDolls();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int m = sc.nextInt();
        int[] moves = new int[m];

        for (int i = 0; i < m; i++) {
            moves[i] = sc.nextInt();
        }

        craneDolls.solution(n, board, m, moves);
    }

    private void solution(int n, int[][] board, int m, int[] moves) {
        int cnt = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i : moves) {
            for (int j = 0; j < n; j++) {
                if (board[j][i-1] != 0) {
                    if (!stack.isEmpty() && stack.peek() == board[j][i - 1]) {
                        // Unboxing of 'stack.peek()' may produce 'NullPointerException', returns null if this deque is empty.
                        stack.pop();
                        cnt+=2;
                    } else {
                        stack.push(board[j][i - 1]);
                    }
                    board[j][i - 1] = 0;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }

    private void solution2(int n, int[][] board, int m, int[] moves) {
        int cnt = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        for (int i : moves) {
            for (int j = 0; j < n; j++) {
                if (board[j][i-1] != 0) {
                    if (stack.getFirst() == board[j][i - 1]) {
                        // This method differs from peekFirst only in that it throws an exception if this deque is empty.
                        stack.pop();
                        cnt+=2;
                    } else {
                        stack.push(board[j][i - 1]);
                    }
                    board[j][i - 1] = 0;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
