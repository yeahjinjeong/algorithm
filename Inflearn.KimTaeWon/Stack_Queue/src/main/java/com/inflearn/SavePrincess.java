package com.inflearn;

import java.util.*;

/**
 * Queue : FIFO
 *
 * - offer()
 * - poll()
 * - peek()
 * - size()
 * - contains() : boolean
 *
 */
public class SavePrincess {
    public static void main(String[] args) {
        SavePrincess savePrincess = new SavePrincess();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        savePrincess.solution(n, k);
    }

    private void solution(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        int cnt = 1;

        while (queue.size() != 1) {
            if (cnt == k) {
                queue.poll();
                cnt = 1;
            } else {
                queue.offer(queue.poll());
                cnt++;
            }
        }

        System.out.print(queue.poll());
    }
}
