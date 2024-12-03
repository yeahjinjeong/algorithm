package com.inflearn;

import java.util.*;

public class PartitionProblemAmazon {

    static Map<Integer, Integer> arr; // key에 원소, value에 집합 포함 여부
    static int n; // 원소의 개수
    static boolean flag = false;

    private void DFS(int L) {
        if (flag) return;
        if (L == n) { // arr을 0부터 도는 중 ( 0부터 시작했으므로 n, 만약 1부터 시작했다면 n+1)
            int sum1 = 0, sum2 = 0;
            for (int k : arr.keySet()) {
                if (arr.get(k) == 1) {
                    sum1 += k;
                } else {
                    sum2 += k;
                }
            }
            if (sum1 == sum2) {
                flag = true;
            }
        } else {
            int key = (int) arr.keySet().toArray()[L];
            arr.put(key, 1);
            DFS(L + 1); // 인덱스 올려서 호출
            arr.put(key, 0);
            DFS(L + 1);
        }
        // 이 방법을 썼을 때는 부분집합의 원소를 세세히 알 수 있음!
    }

    static boolean flag2 = false;
    static int[] arr2;
    static int total = 0;

    private void DFS(int L, int sum) {
        if (flag2) return;
        if (sum > total/2) return;
        if (L == n) {
            if ((total - sum) == sum) {
                flag2 = true;
            }
        } else {
            DFS(L + 1, sum+arr2[L]); // 부분집합에 속함
            DFS(L + 1, sum); // 부분집합에 속하지 않음
        }
        // 이 방법에서는 부분집합의 원소를 알 수 없고, 합만 알 수 있음
    }

    public static void main(String[] args) {
        PartitionProblemAmazon partitionProblemAmazon = new PartitionProblemAmazon();

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        arr = new HashMap<>();
        arr2 = new int[n];

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            arr.put(a, 0);
            arr2[i] = a;
            total += a;
        }

        partitionProblemAmazon.DFS(0);
        if (flag) {
            System.out.println("YES");
        }

        partitionProblemAmazon.DFS(0, 0);
        if (flag2) {
            System.out.println("YES");
        } else System.out.println("NO");
    }
}
/*
6
1 3 5 6 7 10
 */