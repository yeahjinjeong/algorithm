package com.inflearn;

import java.util.*;

public class LeastRecentlyUsed {
    public static void main(String[] args) {
        LeastRecentlyUsed leastRecentlyUsed = new LeastRecentlyUsed();

        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int n = sc.nextInt();

        int[] work = new int[n];
        for (int i = 0; i < n; i++) {
            work[i] = sc.nextInt();
        }

        for (int i : leastRecentlyUsed.solution(s, n, work)) {
            System.out.print(i + " ");
        }
    }

    private List<Integer> solution(int s, int n, int[] work) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!list.contains(work[i])) {
                list.add(0, work[i]);
                if (list.size() > s) {
                    list.remove(s);
                }
            } else {
                for (int j = 0; j < s; j++) {
                    if (list.get(j) == work[i]) {
                        list.remove(j);
                        list.add(0, work[i]);
                        break;
                    }
                }
            }
        }
        return list;
    }
}
