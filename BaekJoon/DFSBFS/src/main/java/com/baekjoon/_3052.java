package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class _3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, Integer> map = new HashMap<>();

        int[] arr = new int[42];

        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine());

            map.put(num % 42, map.getOrDefault(num % 42, 0) + 1);

            arr[num % 42]++;
        }

        System.out.print(map.keySet().size());

        int result = 0;
        for (int i = 0; i < 42; i++) {
            if (arr[i] > 0) result++;
        }

        System.out.print(result);
    }

    private void solution() {

    }
}
