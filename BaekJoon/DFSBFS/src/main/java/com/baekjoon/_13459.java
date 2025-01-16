package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1차 시도시 구멍을 움직여서 R에 네 번 중 한번이라도 먼저 닿는다면 1을 반환하는 방법을 생각했다.
 * 그러나 동시에 구멍에 들어가는 경우를 처리하기가 어려웠다.
 */

public class _13459 {
    static int n, m;
    static int holeRow, holeCol;
    static char[][] board;
    static Set<int[]> visit;
    static int[] dx = {0, 0, -1, 1}; // 상, 하, 좌, 우
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        _13459 _13459 = new _13459();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        visit = new HashSet<>();
        int redRow = 0, redCol = 0, blueRow = 0, blueCol = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j);
                if (board[i][j] == 'O') {
                    holeRow = i;
                    holeCol = j;
                } else if (board[i][j] == 'R') {
                    redRow = i;
                    redCol = j;
                } else if (board[i][j] == 'B') {
                    blueRow = i;
                    blueCol = j;
                }
            }
        }
        BoardCase boardCase = new BoardCase(redRow, redCol, blueRow, blueCol);

        int answer = _13459.BFS(boardCase);
        System.out.println(answer);
    }

    private int BFS(BoardCase boardCase) {
        int level = 1;

        Deque<BoardCase> Q = new LinkedList<>();
        Q.offer(boardCase);
        visit.add(new int[]{boardCase.redRow, boardCase.redCol, boardCase.blueRow, boardCase.blueCol});

        while (level <= 10 && !Q.isEmpty()) {
            int qSize = Q.size();
            for (int q = 0; q < qSize; q++) {
                BoardCase cur = Q.poll();
                for (int i = 0; i < 4; i++) {
                    int[] red = fall(cur.redRow, cur.redCol, i);
                    int[] blue = fall(cur.blueRow, cur.blueCol, i);

                    if (cur.redRow == red[0] && cur.redCol == red[1]
                            && cur.blueRow == blue[0] && cur.blueCol == blue[1]) continue;

                    if (blue[0] == holeRow && blue[1] == holeCol) continue;
                    if (red[0] == holeRow && red[1] == holeCol) return 1;

                    if (Arrays.equals(red, blue)) {
                        adjustPositions(cur, red, blue, i);
                    }

                    BoardCase nextBoardCase = new BoardCase(red[0], red[1], blue[0], blue[1]);
                    // To do : 방문 체크
                    if (visit.add(new int[] {red[0], red[1], blue[0], blue[1]})){
                        Q.offer(nextBoardCase);
                    }
                }
            }
            level++;
        }
        return 0;
    }

    private int[] fall(int row, int col, int i) {
        while (row >= 0 && row < n && col >= 0 && col < m) {
            if (board[row][col] == 'O') return new int[] {row, col}; // 구멍에 도달
            if (board[row][col] == '#') break;
            row += dy[i];
            col += dx[i];
        }
        return new int[] {row - dy[i], col - dx[i]};
    }

    private static void adjustPositions(BoardCase cur, int[] red, int[] blue, int i) {
        switch (i) {
            // 상
            case 0 :
                // 빨간 구슬이 더 밑에 있다면
                if (cur.redRow > cur.blueRow) red[0] += 1; // 빨간 구슬을 한칸 밑으로
                else blue[0] += 1;
                break;
            // 하
            case 1 :
                // 빨간 구슬이 더 밑에 있다면
                if (cur.redRow > cur.blueRow) blue[0] -= 1; // 파란 구슬을 한칸 위로
                else red[0] -= 1;
                break;
            // 좌
            case 2 :
                // 빨간 구슬이 더 오른쪽에 있다면
                if (cur.redCol > cur.blueCol) red[1] += 1; // 빨간 구슬을 한칸 오른쪽으로
                else blue[1] += 1;
                break;
            // 우
            case 3 :
                // 빨간 구슬이 더 오른쪽에 있다면
                if (cur.redCol > cur.blueCol) blue[1] -= 1; // 파란 구슬을 한칸 왼쪽으로
                else red[1] -= 1;
                break;
        }
    }
}

class BoardCase {
    int redRow;
    int redCol;
    int blueRow;
    int blueCol;

    public BoardCase() {
    }

    public BoardCase(int redRow, int redCol, int blueRow, int blueCol) {
        this.redRow = redRow;
        this.redCol = redCol;
        this.blueRow = blueRow;
        this.blueCol = blueCol;
    }
}