package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String s = br.readLine();
        // 작은 거 K개
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            int num = s.charAt(i) - '0';
            while (K > 0 && !queue.isEmpty() && queue.peekLast() < num) { // 큰 수가 나오면 전에 나온 작은 수들을 제거함
                // 제거하다가 K가 다 채워지면, 제거를 멈춘다!
                // K가 남으면 앞에 나온 걸 싹 지운 뒤 다시 탐색,
                // 일단 넣고나서, 커버칠 놈이 나오면 또 지운다 .. 이건 앞자리일수록 큰숫자가 나오는 게 좋기 때문이다
                queue.removeLast(); // 가장 최신에 넣었던..
                K--;
            }
            queue.offerLast(num);
        }

        for (int i = 0; i < K; i++) {
            queue.removeLast();
        }

        while (!queue.isEmpty()) {
            System.out.print(queue.poll());
        }
    }
}
