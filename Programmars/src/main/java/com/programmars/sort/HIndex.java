package com.programmars.sort;

import java.util.Arrays;
import java.util.Scanner;

public class HIndex {
    public static void main(String[] args) {
        HIndex hIndex = new HIndex();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] citations = new int[n];
        for (int i = 0; i < n; i++) {
            citations[i] = sc.nextInt();
        }

        System.out.print(hIndex.solution(citations));
    }

    public int solution(int[] citations) {

        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            if (n - i <= citations[i]) {
                return n - i; // h-index 반환
            }
            /**
             * 5
             * 4 0 6 1 5
             * 0 1 4 5 6
             * 4 > 남은개수(3)
             * H-index = 3
             */
        }
        return 0;
    }

    private int solution2(int[] citations) {
        Arrays.sort(citations);
        int index = 0;
        while (index < citations.length) {
            if (citations.length - index == citations[index]) {
                // 같은 수가 없을 수도 있음!
                return citations[index]; // 4회 이상 인용된 논문의 개수는 4개 이상인가? 아니다!
            }
            index++;
        }
        return 0;
    }

    private int solution3(int[] citations) {
        Arrays.sort(citations);
        int index = 0;
        while (index < citations.length) {
            if (citations.length - index >= citations[index]) {
                // 이건 citations[0]이 바로 출력됨
                return citations.length - index;
            }
            index++;
        }
        return 0;
    }
}
