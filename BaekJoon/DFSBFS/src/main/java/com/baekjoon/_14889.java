package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 스타트와 링크
 *
 * 두 팀으로 나눈 축구팀을 짤 때
 * 모든 쌍의 능력치를 더하여 두 팀의 실력이 가장 비슷한 경우를 출력해라!
 */
public class _14889 {
    static int n, answer = Integer.MAX_VALUE;
    static int[][] score;
    static int[] start, link, pair;
    static int[] visit;
    public static void main(String[] args) throws IOException {
        _14889 _14889 = new _14889();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        score = new int[n + 1][n + 1];
        visit = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 두 팀으로 나눌 수 있는 경우의 수를 구하기 nCn/2
        start = new int[n/2];
        link = new int[n/2];
        pair = new int[2];
        _14889.DFS(0,  1);

        // 능력치를 구하기
        // start 배열을 중복조합으로 구해서 합 저장
        // link 배열을 중복조합으로 구해서 합 저장

        System.out.println(answer);
    }

    private int DFS(int L, int[] arr) {
        int sum = 0;
        if (L == 2) {
            return score[pair[0]][pair[1]];
        } else {
            for (int j = 0; j < n / 2; j++) {
                pair[L] = arr[j];
                sum += DFS(L + 1, arr);
            }
        }
        return sum;
    }

    private void DFS(int L, int f) {
        if (L == n / 2) {
            int j = 0;
            for (int i = 1; i <= n; i++) {
                if (visit[i] == 0) { // 4명 중에 팀에 들어가지 않은 사람은
                    link[j] = i; // 링크팀에 배정
                    j++;
                }
            }
            answer = Math.min(answer, Math.abs(DFS(0, start) - DFS(0, link)));
        } else {
            for (int i = f; i < n; i++) {
                start[L] = i;
                visit[i] = 1;
                DFS(L + 1, i + 1);
                visit[i] = 0;
            }
        }
    }
}
