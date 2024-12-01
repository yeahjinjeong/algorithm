package com.inflearn;

import java.util.*;

public class PartitionProblemAmazon {

    static Map<Integer, Integer> arr; // key에 원소, value에 집합 포함 여부
    static List<Boolean> answer; // sum 저장
    static int n; // 원소의 개수

    public static void main(String[] args) {
        PartitionProblemAmazon partitionProblemAmazon = new PartitionProblemAmazon();

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        arr = new HashMap<>();
        answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            arr.put(a, 0);
        }

        partitionProblemAmazon.DFS(0);

        if (answer.contains(true)) {
            System.out.println("YES");
        } else System.out.println("NO");
    }

    private void DFS(int i) {
        if (i == n) { // arr을 0부터 도는 중 ( 0부터 시작했으므로 n, 만약 1부터 시작했다면 n+1)
            StringBuilder sb = new StringBuilder();
            int sum1 = 0, sum2 = 0;
            for (int k : arr.keySet()) {
                if (arr.get(k) == 1) {
                    sum1 += k;
                } else {
                    sum2 += k;
                }
            }
            if (sum1 == sum2) {
                answer.add(true);
            }
        } else {
            int key = (int) arr.keySet().toArray()[i];
            arr.put(key, 1);
            DFS(i + 1); // 인덱스 올려서 호출
            arr.put(key, 0);
            DFS(i + 1);
        }
    }
}