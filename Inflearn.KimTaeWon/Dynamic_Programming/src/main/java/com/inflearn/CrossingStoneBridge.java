package com.inflearn;

import javax.swing.plaf.basic.BasicRootPaneUI;
import java.util.Scanner;

public class CrossingStoneBridge {
    public static void main(String[] args) {
        CrossingStoneBridge crossingStoneBridge = new CrossingStoneBridge();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(crossingStoneBridge.solution(n));
    }

    private int solution(int n) {
        int[] dy = new int[n + 2];
        dy[1] = 1;
        dy[2] = 2;
        for (int i = 3; i < n + 2; i++) {
            dy[i] = dy[i - 1] + dy[i - 2];
        }
        return dy[n + 1];
    }
}
/**
 * 돌이 N개 라면
 * 마지막 평지에 도착하는 것이 건너는 것
 * dy[N+1] 이 답!
 */