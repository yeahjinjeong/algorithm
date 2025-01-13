package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _17140 {
    static int r, c, k, maxR, maxC;
    static ArrayList<ArrayList<Integer>> board = new ArrayList<>();
    static int maxCSize = 3;
    public static void main(String[] args) throws IOException {
        _17140 _17140 = new _17140();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 배열 A의 모든 행에 대해서 정렬 수행
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                row.add(Integer.parseInt(st.nextToken()));
            }
            board.add(row);
        }

        int time = 0;
        while (time <= 100) {
            if (maxCSize > board.size()) {
                _17140.CSolution();
            } else _17140.RSolution();
            time++;

            if (board.get(r - 1).get(c - 1) == k) {
                System.out.println(time);
                return;
            }
        }
        System.out.println(-1);
    }

    private void RSolution() {
        int newMaxCSize = 0;
        System.out.println("R Solution");
        ArrayList<ArrayList<Integer>> newBoard = new ArrayList<>();
        for (int i = 0; i < board.size(); i++) {
            Map<Integer, Integer> often = new HashMap<>();
            ArrayList<Integer> row = new ArrayList<>();
            for (int r : board.get(i)) {
                often.put(r, often.getOrDefault(r, 0) + 1);
            }

            List<Map.Entry<Integer, Integer>> entryList = sortEntry(often.entrySet());

            for (Map.Entry<Integer, Integer> entry : entryList) {
                row.add(entry.getKey());
                row.add(entry.getValue());
                System.out.print(entry.getKey() + " ");
                System.out.print(entry.getValue() + " ");
            }
            newBoard.add(row);
            newMaxCSize = Math.max(newMaxCSize, row.size());
            System.out.println();
        }
        board = newBoard;
        maxCSize = newMaxCSize;
    }

    private void CSolution() {
        System.out.println("C Solution");
        ArrayList<ArrayList<Integer>> newBoard = new ArrayList<>();
        for (int j = 0; j < maxCSize; j++) {
            Map<Integer, Integer> often = new HashMap<>();
            for (int i = 0; i < board.size(); i++) {
                if (board.get(i).size() > j) {
                    often.put(board.get(i).get(j), often.getOrDefault(board.get(i).get(j), 0) + 1);
                }
            }

            List<Map.Entry<Integer, Integer>> entryList = sortEntry(often.entrySet());
            Deque<Integer> queue = new LinkedList<>();
            for (Map.Entry<Integer, Integer> entry : entryList) {
                queue.offer(entry.getKey());
                queue.offer(entry.getValue());
                System.out.print(entry.getKey() + " ");
                System.out.print(entry.getValue() + " ");
            }

            for (int i = 0; i < board.size(); i++) {
                if (!queue.isEmpty()) {
                    newBoard.get(i).add(queue.poll()); // 필요한 만큼 추가
                }
            }
            System.out.println();
        }
        int currentMax = maxCSize;
        maxCSize = 0;
        for (int j = currentMax - 1; j >= 0; j--) {
            for (int i = 0; i < board.size(); i++) {
                maxCSize = Math.max(maxCSize, board.get(i).size());
                if (board.get(i).size() > j) {
                    board.get(i).remove(j);
                }
            }
        }
    }

    private List<Map.Entry<Integer, Integer>> sortEntry(Set<Map.Entry<Integer, Integer>> oftenEntry) {
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(oftenEntry);
        entryList.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o1.getKey() - o2.getKey();
            }
            return o1.getValue() - o2.getValue();
        });
        return entryList;
    }
}