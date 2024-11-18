package com.inflearn;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 가장 가까운 두 말의 거리가 최대가 되게
 * 가 무슨 뜻일까?
 *
 * 말 중에 가장 가까운 두 말의 거리가
 * 될 수 있는 한, 먼 마구간에 배치해라
 *
 * 5 3
 * 1 2  4   8 9
 * X    X   X
 *
 * 답은 4-1 = 3
 */
public class EstablishStall {
    public static void main(String[] args) {
        EstablishStall establishStall = new EstablishStall();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 마구간의 개수
        int c = sc.nextInt(); // 말의 개수

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        establishStall.solution(n, c, arr);
    }

    private void solution(int n, int c, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);

        int lt = 1;
        int rt = arr[n - 1];
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(arr, mid) >= c) {
                answer = mid;
                lt = mid + 1;
            } else rt = mid - 1;
        }
        System.out.println(answer);
    }

    private int count(int[] arr, int dist) {
        int cnt = 1;
        int ep = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - ep >= dist) { // 두 말 사이의 거리가 주어진 값보다 크면
                cnt++;
                ep = arr[i];
            }
        }
        return cnt;
    }

}
