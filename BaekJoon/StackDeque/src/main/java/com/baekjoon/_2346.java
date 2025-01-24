package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        int[] next = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            next[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            deque.offer(i + 1); // 인덱스 저장, 계속 돌 인덱스
        }

        while (!deque.isEmpty()) {
            int balloon = deque.pollFirst(); // 무조건 맨 앞에 있는 게 배열의 인덱스가 될 것임
            System.out.print(balloon + " ");

            if (deque.isEmpty()) break;
            if (next[balloon - 1] < 0) { // 왼쪽으로 가야 함 (오른쪽 요소들을 가져와야 함)
                for (int i = 0; i < next[balloon - 1] * (-1); i++) { // 얼만큼? 배열의 값만큼
                    deque.offerFirst(deque.pollLast());
                }
            } else { // 오른쪽으로 가야함 (왼쪽 요소들을 없애야 함)
                for (int i = 1; i < next[balloon - 1]; i++) { // 지금있는곳까지 한번으로 쳐야 하기 때문에 1부터 시작, n-1번만큼 회전
                    deque.offerLast(deque.pollFirst());
                }
            }
        }
        /**
         * 3 2 1 -3 -1
         *
         * 1 : 3
         *
         * 2 3 4 5
         *
         * 4 5 2 3
         *
         * 4 : -3
         *
         * 5 2 3
         *
         * 5 2 3
         *
         * 5 : -1
         *
         * 2 3
         *
         * 3 2
         *
         * 3 : 1
         *
         * 2
         *
         * 2 : 2
         *
         * 0
         */

//        long start = System.currentTimeMillis();
//        long end = System.currentTimeMillis();
//        long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
//
//        System.out.println("메모리 : " + (double)usedMemory/1024/1024 + "MB");
//        System.out.println("속도 : " + (end - start)+"ms");
    }
}
