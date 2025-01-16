package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _17140 {
    static int r, c, k;
    static int[][] board = new int[101][101];
    static int maxRSize = 3, maxCSize = 3;
    public static void main(String[] args) throws IOException {
        _17140 _17140 = new _17140();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 배열 A의 모든 행에 대해서 정렬 수행
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while (time <= 100) {
            if (board[r][c] == k) {
                System.out.println(time);
                return;
            }
            if (maxCSize > maxRSize) {
                _17140.CSolution();
            } else _17140.RSolution();
            time++;
        }
        System.out.println(-1);
    }

    private void RSolution() {
        int[][] newBoard = new int[101][101];
        int maxC = 0;
        for (int i = 1; i <= maxRSize; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 1; j <= maxCSize; j++) {
                if (board[i][j] != 0) {
                    map.put(board[i][j], map.getOrDefault(board[i][j], 0) + 1);
                }
            }
            int j = 0;
            for (Map.Entry e : sortEntry(map.entrySet())) {
                j++;
                newBoard[i][j] = (int) e.getKey();
                j++;
                newBoard[i][j] = (int) e.getValue();
            }
            maxC = Math.max(maxC, j);
        }
        maxCSize = maxC;
        board = newBoard;
    }

    private void CSolution() {
        int[][] newBoard = new int[101][101];
        int maxR = 0;
        for (int j = 1; j <= maxCSize; j++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 1; i <= maxRSize; i++) {
                if (board[i][j] != 0) {
                    map.put(board[i][j], map.getOrDefault(board[i][j], 0) + 1);
                }
            }
            int i = 0;
            for (Map.Entry e : sortEntry(map.entrySet())) {
                i++;
                newBoard[i][j] = (int) e.getKey();
                i++;
                newBoard[i][j] = (int) e.getValue();
            }
            maxR = Math.max(maxR, i);
        }
        maxRSize = maxR;
        board = newBoard;
    }

    private List<Map.Entry<Integer, Integer>> sortEntry(Set<Map.Entry<Integer, Integer>> mapEntry) {
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(mapEntry);
        entryList.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o1.getKey() - o2.getKey();
            }
            return o1.getValue() - o2.getValue();
        });
        return entryList;
    }
}