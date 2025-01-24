package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class _14890 {
    static int[][] board;
    static boolean[][] visit;
    static int n, l;
    public static void main(String[] args) throws IOException {
        _14890 _14890 = new _14890();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        _14890.solution();
    }

    private void solution() {
        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (checkPath(i, 0, true)) sum++;
            if (checkPath(0, i, false)) sum++;
        }

        System.out.print(sum);
    }

    private boolean checkPath(int x, int y, boolean row) {
        int[] height = new int[n];
        boolean[] visit = new boolean[n];

        for (int j = 0; j < n; j++) {
            if (row) height[j] = board[x][j];
            else height[j] = board[j][y];
        }

        for (int j = 0; j < n - 1; j++) {
            if (Math.abs(height[j + 1] - height[j]) == 1) {
                // 올라가는 경사
                if (height[j] < height[j + 1]) {
                    for (int k = j; k > j - l; k--) {
                        if (k < 0 || height[k] != height[j] || visit[k]) return false;
                        visit[k] = true;
                    }
                }
                // 내려가는 경사
                else if (height[j] > height[j + 1]) {
                    for (int k = j + 1; k <= j + l; k++) {
                        if (k >= n || height[k] != height[j + 1] || visit[k]) return false; // 해당 줄 탈락!
                        visit[k] = true;
                    }

                }
            }
            // 두 칸 이상 차이나는 경우
            else if (Math.abs(height[j + 1] - height[j]) >= 2) {
                return false; // 해당 줄 탈락!
            }
        }
        return true;
    }

}
