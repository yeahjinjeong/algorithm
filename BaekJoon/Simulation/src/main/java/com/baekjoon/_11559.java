package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _11559 {
    static char[][] GameBoard;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static boolean pop;
    static int answer;

    public static void main(String[] args) throws IOException {
        _11559 _11559 = new _11559();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        GameBoard = new char[12][6];

        for (int i = 0; i < 12; i++) {
            String s = br.readLine();
            for (int j = 0; j < 6; j++) {
                char c = s.charAt(j);
                GameBoard[i][j] = c;
            }
        }

        while (true) {
            pop = false; // pop 없음!

            _11559.BFS();

            if (pop) {
                _11559.onFloor(); // pop 됐으면 한번 쫙 밀고
                answer++; // 한 차례 pop 됐다고 카운팅! (동시에 여러군데에서 터져도 한 번 카운트)
            } else break; // pop 없으면 멈춰 ~~
        }
        System.out.println(answer);
    }

    private void BFS() {
        int[][] visit = new int[12][6];
        Deque<Puyo> queue = new LinkedList<>();

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                // 색깔 별로 진행!
                // 결국 모든 색깔을 한 번씩 다 훑게 될 거야 하지만 방문한 뿌요들은 다 걸러지므로 오래 걸리진 않을 거야
                if (GameBoard[i][j] != '.' && visit[i][j] == 0) { // 게임판을 돌다가 처음 보는 뿌요를 만났다
                    ArrayList<Puyo> list = new ArrayList<>(); // 이 뿌요 근처에 같은 색의 뿌요가 있으면 넣을거야

                    Puyo puyo = new Puyo(i, j, GameBoard[i][j]);
                    queue.offer(puyo); // 이 뿌요의 근처를 탐색하기 위해 큐에 저장
                    list.add(puyo); // 그리고 이 뿌요 색의 수를 세자!
                    visit[i][j] = 1; // 방문마킹

                    while (!queue.isEmpty()) {
                        Puyo curr = queue.poll(); // 방문 마킹이 안 된 근처 뿌요 중에 같은 색깔인 걸 찾아~

                        for (int k = 0; k < 4; k++) {
                            int nr = curr.row + dr[k];
                            int nc = curr.col + dc[k];
                            if (nr < 0 || nr >= 12 || nc < 0 || nc >= 6) continue; // 범위를 벗어나면 for문으로 돌아갈 거야
                            if (GameBoard[nr][nc] == curr.color && visit[nr][nc] == 0) { // 상하좌우에 방문 안 했던 뿌요가 있다!
                                Puyo npuyo = new Puyo(nr, nc, curr.color);
                                queue.offer(npuyo); // 다음 뿌요의 상하좌우도 탐색해야 하므로 큐에 넣어주고
                                list.add(npuyo); // 연속되는 뿌요니까 리스트에도 잘 저장해줄 거야
                                visit[nr][nc] = 1; // 방문 마킹
                            }
                        }
                    } // 일단 상하좌우 다 살펴봤어.. 큐에 들어왔던 연속된 뿌요들의 근처까지 탐색한 결과

                    if (list.size() >= 4) { // 한가지 색에 대하여 4개 이상 연결돼있다?
                        pop = true; // 연쇄가 일어났다고 표시 (이전 색깔에서 연쇄가 일어났었으면 쭉 true였겠지)
                        for (int k = 0; k < list.size(); k++) {
                            // 각 뿌요들의 위치를 저장하고
                            int row = list.get(k).row;
                            int col = list.get(k).col;

                            GameBoard[row][col] = '.'; // 터트려서 빈 칸으로 만듦
                        }
                        // 연쇄가 안 일어났다면 더 이상 탐색을 더 할 필요도 없음! 가능성이 없으니까
                    }
                }
            }
        }
        // 모든 색깔을 다 돌면서 연결돼있는 걸 터뜨렸어 -> 그럼 쫙 밑으로 내리고 다시 시작!
    }

    private void onFloor() {
        for (int j = 0; j < 6; j++) {
            down(j);
        }
    }

    private void down(int j) {
        Deque<Character> puyo = new LinkedList<>();
        for (int i = 11; i >= 0; i--) {
            if (GameBoard[i][j] != '.') {
                puyo.offer(GameBoard[i][j]);
                GameBoard[i][j] = '.';
            }
        }

        while (!puyo.isEmpty()) {
            for (int i = 11; i >= 0; i--) {
                if (puyo.peek() != null) {
                    GameBoard[i][j] = puyo.poll();
                }
            }
        }
    }
}

class Puyo {
    int row;
    int col;
    char color;

    public Puyo(int row, int col, char color) {
        this.row = row;
        this.col = col;
        this.color = color;
    }
}