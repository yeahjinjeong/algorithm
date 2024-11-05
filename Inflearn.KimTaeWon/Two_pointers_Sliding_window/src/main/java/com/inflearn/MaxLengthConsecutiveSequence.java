package com.inflearn;

import java.util.Scanner;

public class MaxLengthConsecutiveSequence {
    public static void main(String[] args) {
        MaxLengthConsecutiveSequence maxLengthConsecutiveSequence = new MaxLengthConsecutiveSequence();
        Scanner sc = new Scanner(System.in);

        int length = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = sc.nextInt();
        }

        maxLengthConsecutiveSequence.solution(length, k, arr);
        maxLengthConsecutiveSequence.solution2(length, k, arr);
        maxLengthConsecutiveSequence.solution3(length, k, arr);
    }

    // 나의 사전 풀이

    /**
     * lt는 가만히 있고, rt가 한칸씩 오른쪽으로 옮기면서 개수를 센다. 0은 두개까지 허용이다. 카운트를 업데이트하다가, 0이 세개가 되는 순간 카운트는 멈춘다.
     * 그리고 맥스값과 카운트값을 비교하여 맥스를 업데이트한다.
     * 이제 rt도 옮겨지고 lt도 옮겨진다. 옮기면서 원래 있던 자리의 값이 0이라면 0의 개수와 카운트를 업데이트 해줘야 한다. 다시 0이 세개가 될때까지 카운트를 한다.
     */

    private void solution(int length, int k, int[] arr) {
        int zero = 0, lt = 0, max = 0, count = 0;
        for (int rt = 0; rt < length; rt++) {
            if (arr[rt] == 1) {
                count++;
            } else {
                zero++;
                if (zero <= k) {
                    count++;
                } else {
                    if (count > max) {
                        max = count;
                    }
                    count++; // 지금 rt가 가리키는 것도 일단 숫자를 세자!
                    // zero = 3인 상태이니
                    while (arr[lt] == 1) {
                        lt++;
                        count--;
                    } // arr[lt]가 0을 만날 때까지 오른쪽으로 가서
                    lt++; // 다시 lt를 앞으로!
                    zero--; // 결국 0의 개수를 k개까지로 줄이고
                    count--; // 카운트도 줄이고
                }
            }
        }
        System.out.println(max);
    }

    // 강의 풀이

    /**
     * rt가  먼저가면서 0을 1로 바꾸면서 숫자를 세고
     * 뒤쫓아 가는 lt가 다시 rt가 바꾼 숫자를 0으로 바꿔둔다
     * 최대 길이는 rt - lt + 1로 구한다
     */

    private void solution2(int length, int k, int[] arr) {
        int count = 0, max = 0;
        int lt = 0;
        for (int rt = 0; rt < length; rt++) {
            if (arr[rt] == 0) count++;
            while (count > k) {
                if (arr[lt] == 0) count--;
                lt++;
            }
            max = Math.max(max, rt-lt+1);
        }
        System.out.println(max);
    }

    // 나의 풀이 : solution refactoring
    private void solution3(int length, int k, int[] arr) {
        int zero = 0, lt = 0, max = 0, count = 0;
        for (int rt = 0; rt < length; rt++) {
            count++;
            if (arr[rt] == 0) {
                zero++;
            }
            if (zero > k) {
                max = Math.max(max, count-1);
            }
            // zero = 3인 상태이니
            while (zero > k) {
                if (arr[lt] == 0) zero--;
                lt++;
                count--;
            }
        }
        System.out.println(max);
    }
}
