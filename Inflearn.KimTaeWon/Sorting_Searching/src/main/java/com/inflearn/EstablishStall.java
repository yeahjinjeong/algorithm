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

        int lt = 1; // 거리는 최소 1
        int rt = arr[n - 1]; // 최대 마지막 좌표값 => (마지막 - 첫번째)가 정확하지만, 한 번의 반복은 성능에 큰 영향을 끼치지 않음
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(arr, mid) >= c) { // 배치한 말이 주어진 말의 개수보다 크거나 같으면,  이 말은 최대는 아닐 수 있어도 일단 배치는 가능하다는 뜻
                answer = mid; // 후보군이 될 수 있는 것!
                lt = mid + 1; // 최대를 확인하기 위해 범위를 좁힌다
            } else rt = mid - 1; // 배치한 말이 적으면 배치를 못 시킬 정도로 간격이 넓다는 뜻이므로 거리를 줄여야 함
        }
        System.out.println(answer);
    }

    private int count(int[] arr, int distance) {
        int cnt = 1;
        int ep = arr[0]; // 첫 말은 일단 맨 앞 마구간에 두는 게 최대 거리를 구하기 유리함! 두세 번째에 두면 그 거리가 낭비됨
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - ep >= distance) { // 두 말 사이의 거리가 주어진 값보다 바로 크거나 같으면
                cnt++; // 배치를 시킴!
                ep = arr[i]; // 그리고 새롭게 배치된 말이 ep가 됨!
            }
        }
        return cnt;
    }
}
