package com.inflearn;

import java.util.Scanner;

public class Mentoring {
    public static void main(String[] args) {
        Mentoring mentoring = new Mentoring();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 가로 - 등수 (반 학생 수)
        int m = sc.nextInt(); // 세로 - 시험 횟수
        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        mentoring.solution(n, m, arr);
    }

    public void solution(int n, int m, int[][] arr) {
        // 1번부터 n번까지의 학생이 있는데 1번 학생이 1,2,3, ... ,n 학생보다 모든 테스트에서 앞서는가?
        int sum = 0;
        for (int i = 1; i <= n; i++) { // 1부터 시작하는 것에 유의하자!
            for (int j = 1; j <= n; j++) {
                int cnt = 0;
                // 이 학생들의 등수를 알아내서 비교하자!
                for (int k = 0; k < m; k++) {
                    int ir = 0, jr = 0;
                    for (int l = 0; l < n; l++) {
                        if (arr[k][l] == i) ir = l;
                        if (arr[k][l] == j) jr = l;
                    } // 인덱스 찾기
                    if (ir < jr) cnt++; // 비교하기
                } // m번의 테스트를 다 비교했을 때
                if (m == cnt) sum++; // i학생과 j학생이 멘토 멘티가 된다면 sum에 1을 더해준다
            } // 그리고 다시 i학생과 j+1학생을 비교한다.
        }
        System.out.println(sum);
    }
}