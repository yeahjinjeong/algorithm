package com.inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CalfBFS {
    int[] dis = {1, -1, 5};
    int[] board;
    Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        CalfBFS calfBFS = new CalfBFS();

        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int e = sc.nextInt();

        System.out.println(calfBFS.BFS(s, e));
    }

    /**
     * +1 -1 +5를 연산하는 트리를 이용한다.
     */
    private int BFS(int s, int e) {
        board = new int[10001]; // 1 ~ 10,000 좌표
        board[s] = 1; // 현수의 위치
        queue.offer(s);
        int level = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) { // 큐의 값들이 root가 됨
                int x = queue.poll(); // 현수는 이동할 거니까 지워!
                for (int j = 0; j < 3; j++) { // 세가지 케이스
                    int nx = x + dis[j]; // 앞으로 한 칸 가거나, 뒤로 한 칸 가거나, 앞으로 다섯 칸 가거나
                    if (nx == e) return level + 1; // 만약 움직였을 때 송아지를 찾는다면 점프의 횟수를 출력한다
                    if (nx >= 1 && nx <= 10000 && board[nx] == 0) { // 송아지를 못 찾는다면 // 현수가 갔던 곳이면 큐에 넣지 않는다!
                        board[nx] = 1; // 일단 갔다는 걸 표시하고
                        queue.offer(nx); // 큐에 넣어놓자
                    }
                }
            }
            level++; // 그리고 점프의 횟수를 증가시킨다
        }
        return 0;
    }


    /**
     * 5가 root
     * 큐에는 6, 4, 10 이 쌓이겠지 // Level 은 1
     * 5-6이 root, 큐에는 4, 10, 7, (5), 11
     * 5-4가 root, 큐에는 10, 7, (5), 11, (5), 3, 9
     * 5-10이 root, 큐에는 7, (5), 11, (5), 3, 9, (11), (9), 15 // Level 은 2
     * 5-6-7이 root, 큐에는 (5), 11, (5), 3, 9, (11), (9), 15, 8, (7), 12
     * 중복 제거 // 5-6-5가 root, 큐에는 11, (5), 3, 9, (11), (9), 15, 8, (7), 12, (6), (4), (10)
     * 5-6-11이 root, 큐에는 (5), 3, 9, (11), (9), 15, 8, (7), 12, (6), (4), (10), (12), (10), 16
     * 중복 제거 // 5-4-5가 root, 큐에는 3, 9, (11), (9), 15, 8, (7), 12, (6), (4), (10), (12), (10), 16, (4), (6), (10)
     * 5-4-3이 root, 큐에는 9, (11), (9), 15, 8, (7), 12, (6), (4), (10), (12), (10), 16, (4), (6), (10), (4), 2, (8)
     * 5-4-9가 root, 큐에는 (11), (9), 15, 8, (7), 12, 6, (4), (10), (12), (10), 16, (4), (6), (10), (4), 2, (8), (10), (8), 14 > Level+1 = 3 return!
     *
     * 왜 이미 간 곳은 root 후보 큐 에서 제외할까? 왜냐하면 원점이 되면 같은 루트를 반복하게 될 뿐이다!
     *
     * 5가 root
     * 큐에는 6, 4, 10 이 쌓이겠지 // Level 은 1
     * (5-)6이 root, 큐에는 4, 10, 7, 11
     * (5-)4가 root, 큐에는 10, 7, 11, 3, 9
     * (5-)10이 root, 큐에는 7, 11, 3, 9, 15 // Level 은 2
     * (5-6-)7이 root, 큐에는 11, 3, 9, 15, 8, 12
     * (5-6-)11이 root, 큐에는 3, 9, 15, 8, 12, 16
     * (5-4-)3이 root, 큐에는 9, 15, 8, 12, 16, 2
     * (5-4-)9가 root, 큐에는 15, 8, 12, 6, 16, 2, 14 > Level+1 = 3 return!
     *
     * 따라서 5-4-9-14 이 루트가 최적이다!
     */
}