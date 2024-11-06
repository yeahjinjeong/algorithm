package com.inflearn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class KindOfSales {
    public static void main(String[] args) {
        KindOfSales kindOfSales = new KindOfSales();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[]arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        kindOfSales.solution(n, k, arr);
        kindOfSales.solution2(n, k, arr);
    }

    private void solution(int n, int k, int[] arr) {
        int lt = 0;
        StringBuilder answer = new StringBuilder();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        answer.append(map.keySet().size()).append(" ");
        // 이 경우엔 rt 증가 -> lt 증가 -> 세기
        for (int rt = k; rt < n; rt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            map.put(arr[lt], map.get(arr[lt]) - 1);
            if (map.get(arr[lt]) == 0) map.remove(arr[lt]);
            answer.append(map.keySet().size()).append(" ");
            lt++;
        }
        System.out.println(answer);
    }

    private void solution2(int n, int k, int[] arr) {
        int lt = 0;
        StringBuilder answer = new StringBuilder();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k-1; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (int rt = k-1; rt < n; rt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1); // 네칸
            answer.append(map.keySet().size()).append(" ");
            // rt 증가 -> 세기 -> lt 증가
            map.put(arr[lt], map.get(arr[lt]) - 1);
            if (map.get(arr[lt]) == 0) map.remove(arr[lt]);
            lt++; // 세칸
        }
        System.out.println(answer);
    }
}
