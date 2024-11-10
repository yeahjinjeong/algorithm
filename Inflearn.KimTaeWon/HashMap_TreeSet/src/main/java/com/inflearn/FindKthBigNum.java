package com.inflearn;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Stream;

public class FindKthBigNum {
    public static void main(String[] args) {
        FindKthBigNum findKthBigNum = new FindKthBigNum();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        findKthBigNum.solution(n, k, arr);
        System.out.println(findKthBigNum.solution2(n, k, arr));
    }

    private void solution(int n, int k, int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int l = j+1; l < n; l++) {
                    set.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }
        if (set.size() < k) {
            System.out.println(-1);
        } else {
            Stream<Integer> sorted = set.stream().sorted(Comparator.reverseOrder());
            System.out.println(sorted.toList().get(k-1));
        }
    }

    private int solution2(int n, int k, int[] arr) {
        TreeSet<Integer> set = new TreeSet<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    set.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }
        int cnt = 0;
        for (int x : set) {
                cnt++;
                if (cnt == k) return x;
        }
        return -1;
    }
}