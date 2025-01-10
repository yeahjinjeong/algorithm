package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1780 {
    static int[][] paper;
    static int minus, zero, plus;
    public static void main(String[] args) throws IOException {
        _1780 _1780 = new _1780();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        _1780.DFS(0, 0, n);
        // 좌측 상단의 위치 대입!

        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }

    private void DFS(int row, int col, int size) {

        if (checkOneColor(row, col, size)) {
            if (paper[row][col] == -1) minus++;
            if (paper[row][col] == 0) zero++;
            if (paper[row][col] == 1) plus++;

            return;
        };

        int newSize = size / 3;

        DFS(row, col, newSize);
        DFS(row + newSize, col, newSize);
        DFS(row + newSize * 2, col, newSize);

        DFS(row, col + newSize, newSize);
        DFS(row + newSize, col + newSize, newSize);
        DFS(row + newSize * 2, col + newSize, newSize);


        DFS(row, col + newSize * 2, newSize);
        DFS(row + newSize, col + newSize * 2, newSize);
        DFS(row + newSize * 2, col + newSize * 2, newSize);
    }

    public boolean checkOneColor(int row, int col, int size) {
        int color = paper[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (color != paper[i][j]) return false;
            }
        }
        return true;
    }
}
