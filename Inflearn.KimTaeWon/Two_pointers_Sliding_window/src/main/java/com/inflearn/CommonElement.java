package com.inflearn;

import java.util.*;

public class CommonElement {
    public static void main(String[] args) {
        CommonElement commonElement = new CommonElement();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] narr = new int[n];
        for (int i = 0; i < n; i++) {
            narr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] marr = new int[m];
        for (int i = 0; i < m; i++) {
            marr[i] = sc.nextInt();
        }
        commonElement.solution(n, narr, m, marr);
        commonElement.solution2(n, narr, m, marr);
    }

    // 시간 초과
    public void solution(int n, int[] narr, int m, int[] marr) {
        List<Integer> list = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while (p1 < n) {
            if (narr[p1] == marr[p2]) {
                list.add(narr[p1]);
                p1++;
                p2 = 0;
            } else if (p2 == m - 1) {
                p1++;
                p2 = 0;
            } else {
                p2++;
            }
        }
        Collections.sort(list);
        String answer = Arrays.toString(list.toArray());
        System.out.println(answer.substring(1, answer.length()-1).replaceAll(",", ""));
    }

    //
    public void solution2(int n, int[] narr, int m, int[] marr) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(narr);
        Arrays.sort(marr);
        int p1 = 0, p2 = 0;
        while (p1 < n && p2 < m) {
            if (narr[p1] == marr[p2]) {
                list.add(narr[p1]);
                p1++;
                p2++;
            } else if (narr[p1] < marr[p2]) p1++;
            else p2++;
        }
        String answer = Arrays.toString(list.toArray());
        System.out.println(answer.substring(1, answer.length()-1).replaceAll(",", ""));
    }
}