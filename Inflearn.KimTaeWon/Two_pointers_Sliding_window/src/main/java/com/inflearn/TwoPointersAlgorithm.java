package com.inflearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TwoPointersAlgorithm {
    public static void main(String[] args) {
        TwoPointersAlgorithm twoPointersAlgorithm = new TwoPointersAlgorithm();

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
        twoPointersAlgorithm.solution(n, narr, m, marr);
    }

    public void solution(int n, int[] narr, int m, int[] marr) {
        List<Integer> arrayList = new ArrayList<>();

        int p1 = 0, p2 = 0;

        while (p1 < n && p2 < m) {
            if (narr[p1] < marr[p2]) {
                arrayList.add(narr[p1]);
                p1++;
            } else {
                arrayList.add(marr[p2]);
                p2++;
            }
        }
        while (p1 < n) {
            arrayList.add(narr[p1]);
            p1++;
        }
        while (p2 < m) {
            arrayList.add(marr[p2]);
            p2++;
        }

        String answer = Arrays.toString(arrayList.toArray());

        System.out.println(answer.substring(1, answer.length()-1).replaceAll(",", ""));
    }
}
