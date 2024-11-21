package com.inflearn;

import java.util.Scanner;

public class SeekSubset {
    static int n;
    static int[] arr;

    public static void main(String[] args) {
        SeekSubset seekSubset = new SeekSubset();

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n + 1]; // 0은 비우고 1부터 시작

        seekSubset.DFS(1);
    }

    private void DFS(int L) {
        if (L == n + 1) {
            StringBuilder tmp = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                if (arr[i] == 1) tmp.append(i).append(" ");
            }
            if (!tmp.isEmpty()) System.out.println(tmp);
        } else {
            arr[L] = 1; // 일단 L을 부분 집합에 포함시켰을 때
            DFS(L + 1); // 발생되는 경우의 수
            // 마지막부터 닫힐 것
            arr[L] = 0; // 하나씩 포함에서 제하면서
            DFS(L + 1); // 발생되는 경우의 수
        }
    }
    // arr[1] = 1 -> arr[2] = 1 -> arr[3] = 1 -> 1 2 3 출력 }
    // -> arr[3] = 0 -> 1 2 출력 }
    // -> arr[2] = 0 -> arr[3] = 1 -> 1 3 출력 }
    // -> arr[3] = 0 -> 1 출력 }
    // -> arr[1] = 0 -> arr[2] = 1 -> arr[3] = 1 -> 2 3 출력 }
    // -> arr[3] = 0 -> 2 출력 }
    // -> arr[2] = 0 -> arr[3] = 1 -> 3 출력 }
}