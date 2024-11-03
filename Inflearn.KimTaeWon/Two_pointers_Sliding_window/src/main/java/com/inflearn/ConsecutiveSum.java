package com.inflearn;

import java.util.Scanner;

public class ConsecutiveSum {
    public static void main(String[] args) {
        ConsecutiveSum consecutiveSum = new ConsecutiveSum();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        consecutiveSum.solution(n);
    }

    private void solution(int n) {
        int answer = 0, sum = 0;
        int lt = 0;
        int m = n/2+1; // 연속된 수를 더할 때 받은 값의 절반 이상 넘어가면 무조건 커진다.
        int[] arr = new int[m];
        for (int i=0; i<m; i++) arr[i] = i +1; // 배열에 1 큰 수로 저장한다.
        for (int rt = 0; rt <m; rt++) { // 오른쪽 포인터
            sum += arr[rt]; // 점점 더 큰 값들을 더하다가
            if (sum == n) answer++; // 같아지면 개수를 세고
            while (sum >= n) { // 만약에 합이 커져버린다면
                sum -= arr[lt++]; // 작은 값들을 빼면서
                if (sum==n) answer++; // 같아졌을 때 개수를 센다
            } // 합이 다시 작아지면 while문이 끝나고 for문이 이어 실행된다
        }
        // 1+2+3+4+5
        // 1+2+3+4+5+6 합이 커지니까
        // 2+3+4+5+6 왼쪽 포인터를 이동하면서 합을 줄인다
        // 3+4+5+6
        // 4+5+6 같아졌을 때 경우의 수를 늘리고
        // 4+5+6+7 다시 오른쪽 포인터를 이동, 합이 커지니까
        // 5+6+7
        // 6+7
        // 6+7+8
        // 7+8
        System.out.println(answer);
    }
}
