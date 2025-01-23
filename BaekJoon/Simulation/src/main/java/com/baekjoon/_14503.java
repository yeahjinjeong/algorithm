package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14503 {
    static int n, m, sum = 0;
    // 북 0 , 동 1, 남 2 , 서 3
    // 바라보는 방향으로 후진  : 북을 보고 있으면 남쪽으로 ... 0 -> 2, 1 -> 3, 2 -> 0, 3 -> 1
    // 반시계 90도 회전 : 북 -> 서 -> 남 -> 동 -> 북
    static int[] dx = {0, 1, 0, -1}; // 북 동 남 서
    static int[] dy = {-1, 0, 1, 0};
    static int[][] board, visit;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visit = new int[n][m];

        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(r, c, d);
        System.out.print(sum);
    }

    private static void DFS(int r, int c, int d) {
        if (board[r][c] == 0) {
            board[r][c] = -1;
            sum++;
        }
        int nc;
        int nr;
        int nd = d;
        for (int i = 0; i < 4; i++) {
            nd = (nd + 3) % 4; // 순회할 때 나머지 공식 꼭 기억하기
            nc = c + dx[nd];
            nr = r + dy[nd];
            if (checkValid(nr, nc) && board[nr][nc] == 0) {
                DFS(nr, nc, nd);
                return;
            }
        }
//        nc = c - dx[d];
        nc = c - dx[nd]; // 네 바퀴를 다 돌고 왔으니 nd는 최초의 d와 같을 것.
        nr = r - dy[d];
        if (checkValid(nr, nc) && board[nr][nc] != 1) {
            DFS(nr, nc, d);
        }
    }

    private static boolean checkValid(int nr, int nc) {
        return nr >= 0 && nr < n && nc >= 0 && nc < m;
    }
}
