package com.inflearn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InsertSort {
    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int next = sc.nextInt();
            arr[i] = next;
            list.add(next);
        }

        for (int i : insertSort.solution(n, arr)) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (int i : insertSort.solution2(n, list)) {
            System.out.print(i + " ");
        }
    }

    private int[] solution(int n, int[] arr) {
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    break;
                }
            }
        }
        return arr;
    }

    /**
     * swith할 경우
     *
     * 11 7 5 6 10 9
     * - 7을 {11}과 비교
     * 7 11 5 6 10 9
     * - 5를 {7, 11}과 비교
     * 5 11 7 6 10 9
     * - 6을 {5, 11, 7}과 비교
     * 5 6 7 11 10 9
     * - 10을 {5, 6, 7, 11}과 비교
     * 5 6 7 10 11 9
     * - 9를 {5, 6, 7, 10, 11}과 비교
     * 5 6 7 9 11 10
     *
     * => 따라서 insert해주어야 한다
     */

    private List<Integer> solution2(int n, List<Integer> list) {
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (list.get(i) < list.get(j)) {
                    int tmp = list.get(i);
                    list.remove(i);
                    list.add(j, tmp);
                    break;
                }
            }
        }
        return list;
    }

    // insert에는 list가 어울린다고 생각하였다!
}
