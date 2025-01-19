package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 최대한 몇칸 지날 수 있냐?
 * DFS로 구해보자
 */
public class _1987 {
    static int R, C;
    static int max = Integer.MIN_VALUE;
    static char[][] board;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        _1987 _1987 = new _1987();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        visit = new boolean[26];

        for (int i = 0; i < R; i++) {
            String string = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = string.charAt(j);
            }
        }

        visit[board[0][0] - 'A'] = true;
        _1987.DFS(0, 0, 1);
        System.out.println(max);
    }

    private void DFS(int r, int c, int sum) {
        boolean flag = false;

        for (int i = 0; i < 4; i++) {
            int nr = r + dy[i];
            int nc = c + dx[i];
            if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visit[board[nr][nc] - 'A']) {
                flag = true;
                visit[board[nr][nc] - 'A'] = true;
                DFS(nr, nc, sum + 1);
                visit[board[nr][nc] - 'A'] = false;
            }
        }

        if (!flag) max = Math.max(max, sum);
    }
}
