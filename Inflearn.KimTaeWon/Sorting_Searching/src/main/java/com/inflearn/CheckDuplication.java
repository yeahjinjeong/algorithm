package com.inflearn;

import java.util.*;

public class CheckDuplication {
    public static void main(String[] args) {
        CheckDuplication checkDuplication = new CheckDuplication();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print(checkDuplication.solution(n, arr));
    }

    private String solution(int n, int[] arr) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (int i : arr) {
            list.add(i);
            set.add(i);
        }

        if (list.size() == set.size()) return "U";

        return "D";
    }
}
