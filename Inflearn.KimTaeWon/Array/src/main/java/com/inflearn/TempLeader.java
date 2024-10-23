package com.inflearn;

import java.util.Scanner;

public class TempLeader {
    public static void main(String[] args) {
        TempLeader tempLeader = new TempLeader();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] classBoard = new int[n][5];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                classBoard[i][j] = sc.nextInt();
            }
        }

        tempLeader.solution(n, classBoard);
    }

    public void solution(int n, int[][] board) {

        int[] sameStudent = new int[n];

/*
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < n; k++) {
                    if (i != k && board[i][j] == board[k][j]) {
                        sameStudent[i]++;
                    }
                }
            }
        }
        // 위 풀이의 문제점 : 1번 학생과 2번 학생이 1,2,3학년 때 같은반이었다면 3번 카운트된다. => 1번 카운트되게 해야 한다.
 */

        for (int i = 0; i < n; i++) { // 번
            for (int j = 0; j < n; j++) { // 번
                for (int k = 0; k < 5; k++) { // 학년
                    if (i != j && board[i][k] == board[j][k]) {
                        sameStudent[i]++;
                        break;
                    }
                }
            }
        }
        // 1번 학생이 1학년 일 때, 2번 학생이 1학년 일 때 비교 -> 같은 반인 적이 있다! -> break -> 2번 학생은 카운트 됐으니 pass
        // 1번 학생이 1학년일 때, 3번 학생이 1학년일 때 비교 ->
        // 1번 학생이 2학년일 때, 3번 학생이 2학년일 때 비교 -> ...

        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            if (sameStudent[i] > sameStudent[maxIndex]) {
                maxIndex = i;
            }
        }
        System.out.println(maxIndex+1);
    }
}
